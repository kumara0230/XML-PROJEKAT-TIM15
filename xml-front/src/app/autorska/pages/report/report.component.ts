import { Component } from '@angular/core';
import { AutorskaService } from 'src/app/services/autorska.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent {

  dateFrom: Date = new Date();
  dateTo: Date = new Date();

  constructor(private autorskaService: AutorskaService) { }

  ngOnInit(): void {

  }

  getReport() {
    const dateDTO = {
      dateFrom: this.dateFrom,
      dateTo: this.dateTo
    }
    this.autorskaService.getReport(dateDTO).subscribe(response => {
      const blob = new Blob([response], { type: 'application/octet-stream' });
      const url = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.download = `AutorskaReport.pdf`;
      link.click();
      window.URL.revokeObjectURL(url);
    });
    console.log(this.dateFrom);
    
  }

}
