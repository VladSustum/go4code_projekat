import { Component, OnInit, Output, EventEmitter, Input, ViewEncapsulation } from '@angular/core';
import { Category } from '../model/category.model';
import {Menu} from '../model/menu.model';

@Component({
  selector: 'app-edit-menu-form',
  templateUrl: './edit-menu-form.component.html',
  styleUrls: ['./edit-menu-form.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class EditMenuFormComponent implements OnInit {

  @Output()
  menuEdited: EventEmitter<Menu> = new EventEmitter();

  @Input()
   public menuToEdit : Menu;

  @Input()
  public categories : Category[];



  constructor() { }

  ngOnInit() {
  }


 editMenu(){
   this.menuEdited.next(this.menuToEdit);
  }

  resetMenuToEdit(){
    this.menuToEdit = new Menu({
      name : '',
      category: new Category({
        name : ''

      }),
      price : 0
    })


  }

}
