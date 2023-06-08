import { Component, OnInit } from '@angular/core';
import { Zahtev } from '../../model/Zahtev';
import { AutorskaService } from 'src/app/services/autorska.service';
import { xml2json } from 'xml-js';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-autorska-home',
  templateUrl: './autorska-home.component.html',
  styleUrls: ['./autorska-home.component.scss']
})
export class AutorskaHomeComponent implements OnInit{

  constructor(private autorskaService: AutorskaService, 
    private authService: AuthService) {}

  zahtevi: Zahtev[] = [];

  ngOnInit(): void {
    
    this.autorskaService.getAll().subscribe({
      next: (res: any) => {
        const result = xml2json(res.toString(), {compact:true, trim: true})
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

    for(const item of items) {
      console.log(item);
      const zahtev = {
        brojPrijave: item['brojPrijave']['_text'],
        datumPodnosenja: item['datumPodnosenja']['_text'],
        podnosilac: item['podnosilac']['email']['_text']
      }
      this.zahtevi.push(zahtev);
    }


  }

}


