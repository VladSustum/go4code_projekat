import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from './model/category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly path="http://localhost:8080/api/categories"

  constructor(private http: HttpClient) { }



  getCategories(): Observable<Category[]>{
    return this.http.get<Category[]>(this.path);
  }
}
