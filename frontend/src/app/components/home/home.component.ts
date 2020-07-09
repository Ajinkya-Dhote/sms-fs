import { Component, OnInit, ViewChild, AfterViewInit, ElementRef } from '@angular/core';
import { DataProviderService } from '@services/data-provider.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort'
import { MatTableDataSource } from '@angular/material/table';
import { merge, Observable, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';
import { SmsData } from '@models/SmsData';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    displayedColumns: string[] = ['city', 'start_date', 'end_date', 'price', 'status', 'color'];
    dataSource = new MatTableDataSource<any>();

    resultsLength = 0;

    rawData: any;


    @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
    @ViewChild(MatSort, {static: true}) sort: MatSort;
    @ViewChild('startDate') startDate: ElementRef;
    @ViewChild('endDate') endDate: ElementRef;


    constructor(private dataService: DataProviderService) { }

    ngOnInit() {
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort

        this.dataSource.sortingDataAccessor = (item, property) => {
            switch (property) {
                case 'start_date':
                case 'end_date': return new Date(item[property]);
                default: return item[property];
            }
        };
    }

    ngAfterViewInit() {

        this.dataService.fetch()
            .subscribe(data => {
                this.dataSource.data = data;
                this.rawData = data;
            });
    }

    addEvent(type: string, event: MatDatepickerInputEvent<Date>) {
        if (this.startDate.nativeElement.value && this.endDate.nativeElement.value) {
            this.dataSource.data = this.rawData.filter((data) => {
                let startTime = new Date(data.start_date);
                let endTime = new Date(data.end_date);

                return startTime >= new Date(this.startDate.nativeElement.value) && endTime <= new Date(this.endDate.nativeElement.value);
            })
        }
    }

    reset() {
        this.startDate.nativeElement.value = null;
        this.endDate.nativeElement.value = null;
        this.endDate = null;
        this.dataSource.data  = this.rawData;
    }
}
