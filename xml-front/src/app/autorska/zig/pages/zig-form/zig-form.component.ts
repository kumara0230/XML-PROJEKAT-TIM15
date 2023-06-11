import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Zahtev } from '../../model/Zahtev';


@Component({
  selector: 'app-zig-form',
  templateUrl: './zig-form.component.html',
  styleUrls: ['./zig-form.component.scss']
})
export class ZigFormComponent implements OnInit {

  zigForm!: FormGroup;
  zahtev: Zahtev = {} as Zahtev;


  ngOnInit(): void {
    this.zigForm = new FormGroup({
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

      }),

      'punomocnik': new FormGroup({
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
      }),

      'tip_ziga': new FormGroup({
        'tip': new FormControl(null, Validators.required),
        'transliteracija': new FormControl(null),
        'prevod': new FormControl(null)
      }),
      'vrsta_ziga': new FormGroup({
        'vrsta': new FormControl(null, Validators.required)
      }),
      'opis_ziga': new FormGroup({
        'opis': new FormControl(null, Validators.required),
        'boje': new FormControl(null, Validators.required),
        'prava': new FormControl(null, Validators.required),
        'klasa': new FormControl(null, Validators.required)
      })
    })
  }


}
