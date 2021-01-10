import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { HikingTrail } from '../../shared/models/hiking-trail.model';

@Injectable({
    providedIn: 'root'
})
export class HttpService {

    constructor(private http: HttpClient) {
    }

    getHikingTrails(): Observable<HikingTrail[]> {
        return this.http.get<HikingTrail[]>(environment.apiUri + 'hikingTrails');
    }
}
