import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import DecodeJwt from 'src/app/helpers/decodeJwt';
import { AutorskaService } from 'src/app/services/autorska.service';
import { ZigService } from 'src/app/services/zig.service';

@Component({
  selector: 'app-resenje-modal',
  templateUrl: './resenje-modal.component.html',
  styleUrls: ['./resenje-modal.component.scss']
})
export class ResenjeModalComponent implements OnInit {

  obrazlozenje: string = '';
  zahtev: any;
  service: any;

  constructor(
    public dialogRef: MatDialogRef<ResenjeModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private autorskaService: AutorskaService,
    private toastr: ToastrService,
    private zigService: ZigService
  ) { }


  ngOnInit(): void {

    console.log(this.data);
    this.zahtev = this.data.zahtev;
    this.service = this.data.service;

  }

  odobriZahtev() {
    const user = DecodeJwt.getUserFromAuthToken();

    const resenje = {
      imeSluzbenika: user?.firstName,
      prezimeSluzbenika: user?.lastName,
      brZahteva: this.zahtev.brojPrijave,
      emailPodnosioca: this.zahtev.podnosilac
    }
    this.sendResenje(resenje);
    this.dialogRef.close();
  }

  odbijZahtev() {
    const user = DecodeJwt.getUserFromAuthToken();

    const resenje = {
      imeSluzbenika: user?.firstName,
      prezimeSluzbenika: user?.lastName,
      brZahteva: this.zahtev.brojPrijave,
      obrazlozenje: this.obrazlozenje,
      emailPodnosioca: this.zahtev.podnosilac
    }
    this.sendResenje(resenje);
    this.dialogRef.close();
  }

  sendResenje(resenje: any) {
    if (this.service === "autorska") {
      this.sendAutorskaResenje(resenje);
    }
    else if (this.service === "zig") {
      this.sendZigResenje(resenje);
    }
  }

  sendAutorskaResenje(resenje: any) {
    this.autorskaService.sendResenje(resenje).subscribe({
      next: () => {
        this.toastr.success('Success!');
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  sendZigResenje(resenje: any) {
    this.zigService.sendResenje(resenje).subscribe({
      next: () => {
        this.toastr.success('Success!');
      },
      error: (err) => {
        console.log(err);
      }
    })
  }
}
