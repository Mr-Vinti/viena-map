import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { HikingTrail } from '../../../shared/models/hiking-trail.model';
import { HttpService } from '../../../core/http/http.service';

@Component({
  selector: 'app-component-one',
  templateUrl: './component-one.component.html',
  styleUrls: ['./component-one.component.scss'],
})
export class ComponentOneComponent implements OnInit {
  hikingTrails: HikingTrail[];

  constructor(public dialog: MatDialog, public service: HttpService) {}

  ngOnInit(): void {
    this.service.getHikingTrails().subscribe(results => {
      this.hikingTrails = results;
      console.log(this.hikingTrails);
    });
  }
}
