import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ResenjeModalComponent } from 'src/app/autorska/pages/resenje-modal/resenje-modal.component';
import { Zahtev } from 'src/app/patenti/model/Zahtev';
import { AuthService } from 'src/app/services/auth.service';
import { PatentiService } from 'src/app/services/patenti.service';
import { xml2json } from 'xml-js';

@Component({
  selector: 'app-patenti-home',
  templateUrl: './patenti-home.component.html',
  styleUrls: ['./patenti-home.component.scss']
})
export class PatentiHomeComponent {

  constructor(
    private patentiService: PatentiService,
    private authService: AuthService,
    private dialog: MatDialog) { }

  zahtevi: Zahtev[] = [];

  ngOnInit(): void {

    this.patentiService.getAll().subscribe({
      next: (res: any) => {
        const result = xml2json(res.toString(), { compact: true, trim: true })
        const parsedData = JSON.parse(result);
        this.fillZahtevi(parsedData);
      },
      error: (err: any) => {
        console.log(err);
      }
    })

  }

  getRole() {
    return this.authService.getRole();
  }

  fillZahtevi(parsedData: any) {
    const items = parsedData['ArrayList']['item'];
    if (!items) {
      this.zahtevi = [];
      return;
    }

    if (typeof items[Symbol.iterator] === 'function') {
      for (const item of items) {
        const zahtev = {
          brojPrijave: item['brojPrijave']['_text'],
          datumPodnosenja: item['datumPodnosenja']['_text'],
          podnosilac: item['podnosilac']['email']['_text']
        }
        this.zahtevi.push(zahtev);
      }
    }
    else {
      const zahtev = {
        brojPrijave: items['brojPrijave']['_text'],
        datumPodnosenja: items['datumPodnosenja']['_text'],
        podnosilac: items['podnosilac']['email']['_text']
      }
      this.zahtevi.push(zahtev);
    }
    
   
  }

  otvoriModal(zahtev: any) {
    const dialogRef = this.dialog.open(ResenjeModalComponent, {
      // width: '500px',
      data: {service: 'patenti', zahtev: zahtev} 
    });

    dialogRef.afterClosed().subscribe(result => {
      // Proverite povratne vrednosti moda (npr. result) i izvršite odgovarajuće radnje
    });
  }

  getPdf(format: string, brZahteva: string) {
    this.patentiService.getPdf(format, brZahteva).subscribe(response => {
      const blob = new Blob([response], { type: 'application/octet-stream' });
      const url = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.download = `${brZahteva}.${format}`;
      link.click();
      window.URL.revokeObjectURL(url);
    });
  }

}
