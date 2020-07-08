import { Component, OnInit } from '@angular/core';
import { DataProviderService } from '@services/data-provider.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private dataService: DataProviderService) { }

  ngOnInit(): void {
      this.dataService.fetch()
          .subscribe(data => {
              console.log(data);
          })
  }

}
