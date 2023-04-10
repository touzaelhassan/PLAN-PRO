import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private host = environment.APIEnpointsURL;

  constructor(private http: HttpClient) { }


  public getCategories(): Observable<Category[]>{ return this.http.get<Category[]>(`${this.host}/api/categories`); }

}
