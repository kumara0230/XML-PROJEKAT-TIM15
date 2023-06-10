import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Zahtev } from 'src/app/patenti/model/Zahtev';



@Component({
  selector: 'app-patenti-form',
  templateUrl: './patenti-form.component.html',
  styleUrls: ['./patenti-form.component.scss']
})
export class PatentiFormComponent {

  patentiForm!: FormGroup;
  zahtev: Zahtev = {} as Zahtev;

  ngOnInit(): void {
    this.patentiForm = new FormGroup({
      'nazivPronalaska': new FormGroup({
        'nazivNaSrpskom': new FormControl(null, Validators.required),
        'nazivNaEngleskom': new FormControl(null, Validators.required),
      }),

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

        'podnosilacPronalazac': new FormControl(false, Validators.required),

      }),

      'pronalazac': new FormGroup({
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

        'poslovnoIme': new FormControl(null),       // ako je autor pravno lice
      }),

      'predstavnik': new FormGroup({
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

        'poslovnoIme': new FormControl(null),       // ako je predstavnik pravno lice

        'punomocnik':  new FormControl(null, Validators.required), //stringovi kao enumeracija zastupanje, primejm_pismena
        // OVO punomocnik treba da bude radio button i da bira jedan od 2, zastupanje, ili prijem pismena
        'zajednicki_predstavnik':  new FormControl(false, Validators.required), // boolean true, false

      }),

      'dostavljanje': new FormGroup({
        'ulica': new FormControl(null, Validators.required),
        'broj': new FormControl(null, Validators.required),
        'mesto': new FormControl(null, Validators.required),
        'postanskiBroj': new FormControl(null, Validators.required),

        'dostavljanje_elektronskim_putem': new FormControl(false),
      }),

      'zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava': new FormGroup({
        'brojRanijePrijave1': new FormControl(null),
        'datumPodnosenjaRanijePrijave1': new FormControl(null),
        'dvoslovnaOznaka1': new FormControl(null), 

        'brojRanijePrijave2': new FormControl(null),
        'datumPodnosenjaRanijePrijave2': new FormControl(null),
        'dvoslovnaOznaka2': new FormControl(null), 

      }),
    })

  }

}
