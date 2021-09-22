import {
  Component,
  OnInit,
  ViewEncapsulation,
  Input,
  Output,
  EventEmitter
} from '@angular/core';
import { Menu } from '../model/menu.model';

@Component({
  selector: 'tr[app-menu-list-item]',
  templateUrl: './menu-list-item.component.html',
  styleUrls: ['./menu-list-item.component.css']
})
export class MenuListItemComponent implements OnInit {

@Input()
 public menu : Menu;

  @Output()
  menuDeleted : EventEmitter<number> = new EventEmitter();

  @Output()
  markMenuForEditing: EventEmitter<Menu> = new EventEmitter();



  constructor(

  ) { }

  ngOnInit() {

  }


  deleteMenu(){
    this.menuDeleted.next(this.menu.id);
  }


editMenu(){
  this.markMenuForEditing.next(this.menu);
  }

}
