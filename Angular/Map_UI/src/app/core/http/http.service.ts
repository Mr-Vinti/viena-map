import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { HikingTrail } from '../../shared/models/hiking-trail.model';
import { Park } from '../../shared/models/park.model';
import { TouristRoute } from '../../shared/models/tourist-route.model';
import { TouristAttraction } from '../../shared/models/tourist-attraction.model';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  constructor(private http: HttpClient) {}

  getHikingTrails(name: string): Observable<HikingTrail[]> {
    let params = new HttpParams();
    if (name) {
      params = params.set('name:like', name);
    }

    return this.http.get<HikingTrail[]>(environment.apiUri + 'hikingTrails', {
      params,
    });
  }

  getParks(name: string): Observable<Park[]> {
    let params = new HttpParams();
    if (name) {
      params = params.set('name:like', name);
    }
    return this.http.get<Park[]>(environment.apiUri + 'parks', {
      params,
    });
  }

  getTouristAttractions(name: string): Observable<TouristAttraction[]> {
    let params = new HttpParams();
    if (name) {
      params = params.set('name:like', name);
    }
    return this.http.get<TouristAttraction[]>(
      environment.apiUri + 'touristAttractions',
      {
        params,
      }
    );
  }

  getTouristRoutes(name: string): Observable<TouristRoute[]> {
    let params = new HttpParams();
    if (name) {
      params = params.set('name:like', name);
    }
    return this.http.get<TouristRoute[]>(environment.apiUri + 'touristRoutes', {
      params,
    });
  }
}
