import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

import { Category } from '../model/category.model';
import { Menu } from '../model/menu.model';

@Component({
  selector: 'app-add-menu-form',
  templateUrl: './add-menu-form.component.html',
  styleUrls: ['./add-menu-form.component.css']
})
export class AddMenuFormComponent implements OnInit {



  @Output()
  menuAdded : EventEmitter<Menu> = new EventEmitter();

  @Input()
  public categories : Category[];

  public menuToAdd : Menu;






  constructor() { }

  ngOnInit() {
    this.resetMenuToAdd();
  }







  addMenu(){
    this.menuAdded.next(this.menuToAdd);
    this.resetMenuToAdd();
  }


  resetMenuToAdd(){
    this.menuToAdd = new Menu({
      name : '',
      category: new Category({
        name : ''

      }),
      price : 0
    })


  }

}
