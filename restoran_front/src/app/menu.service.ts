import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Menu} from './model/menu.model'
import { MenuPage } from './model/menu-page.model';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private readonly path="http://localhost:8080/api/menus";

  constructor(private http: HttpClient) { }

  getMenus() : Observable<Menu[]>{
    return this.http.get<Menu[]>(this.path);
  }

  getMenusPaged(page,size): Observable<MenuPage>{
    const params = new HttpParams()
    .set('page', page)
    .set('size', size)

    return this.http.get<MenuPage>(this.path, {params});
  }


  getMenu(id : number): Observable<Menu>{
    return this.http.get<Menu>(`${this.path}/${id}`);
  }

  searchMenu(name: string) : Observable<Menu[]>{
    const params : HttpParams = new HttpParams().append('name', name);
    return this.http.get<Menu[]>(this.path, {params})
  }

  postMenu(menu : Menu) : Observable<Menu>{
    return this.http.post<Menu>(this.path, menu );
  }

  deleteMenu(id: number) : Observable<Menu>{
    return this.http.delete<Menu>(`${this.path}/${id}`);
  }

  putMenu(menu: Menu): Observable<Menu>{
    return this.http.put<Menu>(`${this.path}/${menu.id}`, menu);
  }
}
