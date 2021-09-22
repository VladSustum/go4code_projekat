import { Component, Input, OnInit, Output, ViewEncapsulation, EventEmitter } from '@angular/core';
import {Menu, MenuInterface} from '../model/menu.model'
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class MenuListComponent implements OnInit {

  @Input()
  public menus : MenuInterface[];

  @Output()
  menuDeleted : EventEmitter<number> = new EventEmitter();

  @Output()
  markMenuForEditing : EventEmitter<Menu> = new EventEmitter();


  constructor() { }

  ngOnInit(
    
  )  {


  }

  deleteMenu(id : number){
    this.menuDeleted.next(id);
  }

  editMenu(menu: Menu){
    this.markMenuForEditing.next(menu);
  }

}
