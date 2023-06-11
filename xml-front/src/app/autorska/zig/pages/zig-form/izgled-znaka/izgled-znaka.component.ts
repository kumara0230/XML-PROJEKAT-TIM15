import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from '../../../model/Zahtev';
import * as JsonToXML from "js2xmlparser";
import { ZigService } from 'src/app/services/zig.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-izgled-znaka',
  templateUrl: './izgled-znaka.component.html',
  styleUrls: ['./izgled-znaka.component.scss']
})
export class IzgledZnakaComponent implements OnInit{

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor(private zigService: ZigService, private router: Router, private toastr: ToastrService) {}

  ngOnInit(): void {
      
  }

  handleFileInput(event: any) {
    const file: File = event.target.files[0];
    // Process the file here
  }

  next() {

    this.zigService.sendNewRequest(this.zahtev).subscribe({
      next: () => {
        this.toastr.success('Request is successfully sent');
        this.router.navigate(['/zig']);
      },
      error: (err) => {
        this.toastr.error(err.error);
      }
    });
  }


}
