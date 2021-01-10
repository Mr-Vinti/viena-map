import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { HikingTrail } from '../../../shared/models/hiking-trail.model';
import { Park } from '../../../shared/models/park.model';
import { TouristAttraction } from '../../../shared/models/tourist-attraction.model';
import { TouristRoute } from '../../../shared/models/tourist-route.model';
import { HttpService } from '../../../core/http/http.service';

@Component({
  selector: 'app-component-one',
  templateUrl: './component-one.component.html',
  styleUrls: ['./component-one.component.scss'],
})
export class ComponentOneComponent implements OnInit {
  hikingTrails: HikingTrail[];
  parks: Park[];
  touristAttractions: TouristAttraction[];
  touristRoutes: TouristRoute[];

  constructor(public dialog: MatDialog, public service: HttpService) {}

  ngOnInit(): void {
    this.service.getHikingTrails().subscribe(results => {
      this.hikingTrails = results;
      console.log(this.hikingTrails);
    });

    this.service.getParks().subscribe(results => {
      this.parks = results;
      console.log(this.parks);
    });

    this.service.getTouristAttractions().subscribe(results => {
      this.touristAttractions = results;
      console.log(this.touristAttractions);
    });
    
    this.service.getTouristRoutes().subscribe(results => {
      this.touristRoutes = results;
      console.log(this.touristRoutes);
    });
  }
}
