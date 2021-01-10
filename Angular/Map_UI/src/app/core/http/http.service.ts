import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { HikingTrail } from '../../shared/models/hiking-trail.model';
import { Park } from '../../shared/models/park.model';
import { TouristRoute } from '../../shared/models/tourist-route.model';
import { TouristAttraction } from '../../shared/models/tourist-attraction.model';

@Injectable({
    providedIn: 'root'
})
export class HttpService {

    constructor(private http: HttpClient) {
    }

    getHikingTrails(): Observable<HikingTrail[]> {
        return this.http.get<HikingTrail[]>(environment.apiUri + 'hikingTrails');
    }

    getParks(): Observable<Park[]> {
        return this.http.get<Park[]>(environment.apiUri + 'parks');
    }

    getTouristAttractions(): Observable<TouristAttraction[]> {
        return this.http.get<TouristAttraction[]>(environment.apiUri + 'touristAttractions');
    }

    getTouristRoutes(): Observable<TouristRoute[]> {
        return this.http.get<TouristRoute[]>(environment.apiUri + 'touristRoutes');
    }
}
