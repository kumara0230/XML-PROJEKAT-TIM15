import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/autorska/model/Zahtev';

@Component({
  selector: 'app-delo-prerade-details',
  templateUrl: './delo-prerade-details.component.html',
  styleUrls: ['./delo-prerade-details.component.scss']
})
export class DeloPreradeDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() { }

  ngOnInit(): void {

  }


  isDeloPrerade() {
    return this.form.value['delo']['isDeloPrerade'];
  }


  next() { // finish
    this.form.get('deloPrerade')!.markAllAsTouched();
    this.form.get('deloPrerade')!.updateValueAndValidity();

    this.zahtev.delo!.deloPrerade = {
      naslovIzvornogDela: this.form.value['deloPrerade']['naslovIzvornogDela'],
      ime: this.form.value['deloPrerade']['ime'],
      prezime: this.form.value['deloPrerade']['prezime'],
      pseudonim: this.form.value['deloPrerade']['pseudonim'],
      godinaSmrti: this.form.value['deloPrerade']['godinaSmrti'],
    }

    console.log("FINISHHHH");
    console.log(this.zahtev);
    
    
  }
}
