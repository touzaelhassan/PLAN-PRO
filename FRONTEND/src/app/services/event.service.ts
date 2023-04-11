import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Event } from '../models/event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private host = environment.APIEnpointsURL;

  constructor(private http: HttpClient) { }

  public getEvents(): Observable<Event[]>{ return this.http.get<Event[]>(`${this.host}/api/events`); }

}
