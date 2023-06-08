import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Zahtev } from '../../model/Zahtev';

@Component({
  selector: 'app-autorska-form',
  templateUrl: './autorska-form.component.html',
  styleUrls: ['./autorska-form.component.scss']
})
export class AutorskaFormComponent implements OnInit {

  autorskaForm!: FormGroup;
  zahtev: Zahtev = {} as Zahtev;

  ngOnInit(): void {
    this.autorskaForm = new FormGroup({
      'podnosilac': new FormGroup({
        'ulica': new FormControl(null, Validators.required),
        'broj': new FormControl(null, Validators.required),
        'mesto': new FormControl(null, Validators.required),
        'postanskiBroj': new FormControl(null, Validators.required),

        'brojTelefona': new FormControl(null, Validators.required),
        'email': new FormControl(null, Validators.required),
        'faks': new FormControl(null),

        'ime': new FormControl(null),
        'prezime': new FormControl(null),
        'drzavljanstvo': new FormControl(null),

        'poslovnoIme': new FormControl(null),

        'podnosilacAutor': new FormControl(false, Validators.required),
      }),

      'autor': new FormGroup({
        'ulica': new FormControl(null),
        'broj': new FormControl(null),
        'mesto': new FormControl(null),
        'postanskiBroj': new FormControl(null),

        'brojTelefona': new FormControl(null),
        'email': new FormControl(null),
        'faks': new FormControl(null),

        'ime': new FormControl(null),
        'prezime': new FormControl(null),
        'drzavljanstvo': new FormControl(null),

        'pseudonim': new FormControl(null),
        'godinaSmrti': new FormControl(null),
        'autorAnoniman': new FormControl(null),
      }),

      'punomocnik': new FormGroup({
        'ulica': new FormControl(null, Validators.required),
        'broj': new FormControl(null, Validators.required),
        'mesto': new FormControl(null, Validators.required),
        'postanskiBroj': new FormControl(null, Validators.required),

        'ime': new FormControl(null, Validators.required),
        'prezime': new FormControl(null, Validators.required),
      }),

      'delo': new FormGroup({
        'naslov': new FormControl(null, Validators.required),
        'vrsta': new FormControl(null, Validators.required),
        'formaZapisa': new FormControl(null, Validators.required),
        'alternativniNaziv': new FormControl(null),
        'deloStvorenoURadnomOdnosu': new FormControl(false),
        'nacinKoriscenjaDela': new FormControl(null, Validators.required),
        'isDeloPrerade': new FormControl(false),
      }),
      'deloPrerade': new FormGroup({
        'naslovIzvornogDela': new FormControl(null, Validators.required),
        'ime': new FormControl(null, Validators.required),
        'prezime': new FormControl(null, Validators.required),
        'pseudonim': new FormControl(null),
        'godinaSmrti': new FormControl(null),
      })
    })

  }


}
