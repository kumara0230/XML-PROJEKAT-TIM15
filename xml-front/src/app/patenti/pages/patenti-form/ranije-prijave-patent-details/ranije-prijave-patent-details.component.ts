import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Zahtev } from 'src/app/patenti/model/Zahtev';
import { PatentiService } from 'src/app/services/patenti.service';

@Component({
  selector: 'app-ranije-prijave-patent-details',
  templateUrl: './ranije-prijave-patent-details.component.html',
  styleUrls: ['./ranije-prijave-patent-details.component.scss'],
})
export class RanijePrijavePatentDetailsComponent {
  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor(private patentiService: PatentiService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {}

  next() {
    this.form
      .get('zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava')!
      .markAllAsTouched();
    this.form
      .get('zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava')!
      .updateValueAndValidity();

    const formValues = this.form.get('zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava = {};

    for (const key in formValues) {
      if (formValues[key] && !adresaFileds.includes(key)) {
        this.zahtev.zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava[key] = formValues[key];
      }
    }

    console.log('SENDING TO BACKEND');
    console.log(this.zahtev);
    console.log('SENT TO BACKEND');
    this.patentiService.sendNewRequest(this.zahtev).subscribe({
      next: () => {
        this.toastr.success('Request is successfully sent');
        // this.router.navigate(['/autorska']);
      },
      error: (err) => {
        this.toastr.error(err.error);
      }
    });
    
  }
}
