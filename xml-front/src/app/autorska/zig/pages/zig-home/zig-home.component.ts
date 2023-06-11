import { Component, OnInit } from '@angular/core';
import { ZigService } from 'src/app/services/zig.service';
import { xml2json } from 'xml-js';
import { Zahtev } from '../../model/Zahtev';
import { AuthService } from 'src/app/services/auth.service';
import { MatDialog } from '@angular/material/dialog';
import { ResenjeModalComponent } from 'src/app/autorska/pages/resenje-modal/resenje-modal.component';

@Component({
  selector: 'app-zig-home',
  templateUrl: './zig-home.component.html',
  styleUrls: ['./zig-home.component.scss']
})
export class ZigHomeComponent implements OnInit {

  constructor (private zigService: ZigService, private authService: AuthService, private dialog: MatDialog) {}

  zahtevi: Zahtev[] = [];

  ngOnInit(): void {

    this.zigService.getAll().subscribe({
      next: (res: any) => {
        const result = xml2json(res.toString(), { compact: true, trim: true })
        const parsedData = JSON.parse(result);
        this.fillZahtevi(parsedData);
        console.log(this.zahtevi);
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
    console.log(parsedData)
    const items = parsedData['ArrayList']['item'];
    console.log(items)

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
    console.log("ovde samm")
    console.log(this.zahtevi)
  }

  otvoriModal(zahtev: any) {
    const dialogRef = this.dialog.open(ResenjeModalComponent, {
      // width: '500px',
      data: {
        service: "zig",
        zahtev: zahtev 
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      // Proverite povratne vrednosti moda (npr. result) i izvršite odgovarajuće radnje
    });
  }

  getPdf(format: string, brZahteva: string) {
    this.zigService.getPdf(format, brZahteva).subscribe(response => {
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
