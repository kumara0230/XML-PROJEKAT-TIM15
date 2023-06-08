import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import DecodeJwt from 'src/app/helpers/decodeJwt';
import { AutorskaService } from 'src/app/services/autorska.service';

@Component({
  selector: 'app-resenje-modal',
  templateUrl: './resenje-modal.component.html',
  styleUrls: ['./resenje-modal.component.scss']
})
export class ResenjeModalComponent implements OnInit {

  obrazlozenje: string = '';

  constructor(
    public dialogRef: MatDialogRef<ResenjeModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private autorskaService: AutorskaService,
    private toastr: ToastrService,
  ) { }


  ngOnInit(): void {

  }

  odobriZahtev() {
    const user = DecodeJwt.getUserFromAuthToken();

    const resenje = {
      imeSluzbenika: user?.firstName,
      prezimeSluzbenika: user?.lastName,
      brZahteva: this.data.brojPrijave,
    }
    this.sendResenje(resenje);
    this.dialogRef.close();
  }

  odbijZahtev() {
    const user = DecodeJwt.getUserFromAuthToken();

    const resenje = {
      imeSluzbenika: user?.firstName,
      prezimeSluzbenika: user?.lastName,
      brZahteva: this.data.brojPrijave,
      obrazlozenje: this.obrazlozenje,
    }
    this.sendResenje(resenje);
    this.dialogRef.close();
  }

  sendResenje(resenje: any) {
    this.autorskaService.sendResenje(resenje).subscribe({
      next: () => {
        this.toastr.success('Success!');
      },
      error: (err) => {
        console.log(err);
      }
    })
  }
}
