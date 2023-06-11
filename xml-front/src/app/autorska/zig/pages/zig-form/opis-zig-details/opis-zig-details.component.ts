import { Component, OnInit, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from '../../../model/Zahtev';

@Component({
  selector: 'app-opis-zig-details',
  templateUrl: './opis-zig-details.component.html',
  styleUrls: ['./opis-zig-details.component.scss']
})
export class OpisZigDetailsComponent implements OnInit{

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  numbers: number[] = Array.from({ length: 45 }, (_, i) => i + 1);
  selectedNumbers: number[] = [];

  selectedOption: string | any;
  isOptionSelected: boolean | any;

  opis: string = "";
  boje: string = "";
  prava: string = "";

  constructor() {}

  ngOnInit(): void {
      

  }

  toggleCheckbox(num: number): void {
    const index = this.selectedNumbers.indexOf(num);
    if (index > -1) {
      this.selectedNumbers.splice(index, 1);
    } else {
      this.selectedNumbers.push(num);
    }
  }

  optionChangedKind(event: any) {
    this.selectedOption = event.value;
    this.isOptionSelected = this.selectedOption === "1"; // Change the value as needed
  }

  next() {

    this.zahtev.opis = this.opis;
    this.zahtev.boje = this.boje;
    this.zahtev.prava = this.prava;
    this.zahtev.klasa = this.selectedOption;

    console.log(this.zahtev)
  }

  

}
