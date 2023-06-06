import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/autorska/model/Zahtev';

@Component({
  selector: 'app-podnosilac-details',
  templateUrl: './podnosilac-details.component.html',
  styleUrls: ['./podnosilac-details.component.scss']
})
export class PodnosilacDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() {}

  ngOnInit(): void {
      
  }

  next() {
    this.form.get('podnosilac')!.markAllAsTouched();
    this.form.get('podnosilac')!.updateValueAndValidity();
    this.zahtev.podnosilac = {
      ulica: this.form.value['podnosilac']['ulica'],
      broj: this.form.value['podnosilac']['broj'],
      mesto: this.form.value['podnosilac']['mesto'],
      postanskiBroj: this.form.value['podnosilac']['postanskiBroj'],
      brojTelefona: this.form.value['podnosilac']['brojTelefona'],
      email: this.form.value['podnosilac']['email'],
      faks: this.form.value['podnosilac']['faks'],
      ime: this.form.value['podnosilac']['ime'],
      prezime: this.form.value['podnosilac']['prezime'],
      drzavljanstvo: this.form.value['podnosilac']['drzavljanstvo'],
      poslovnoIme: this.form.value['podnosilac']['poslovnoIme'],
      podnosilacAutor: this.form.value['podnosilac']['podnosilacAutor'],
    }
    console.log(this.form);
    console.log(this.zahtev);
    
  }
  


}
