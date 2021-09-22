import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { MenuService } from '../menu.service';
import { Category } from '../model/category.model';
import { Menu, MenuInterface } from '../model/menu.model';

@Component({
  selector: 'app-menus-page',
  templateUrl: './menus-page.component.html',
  styleUrls: ['./menus-page.component.css']
})
export class MenusPageComponent implements OnInit {

  public menus: MenuInterface[];

  public activeMenu : MenuInterface;

  public categories: Category[];

  public page =0;
  public size= 10;
  public last= false;
  public toAdd: boolean;

  constructor(
    private categoryService : CategoryService,
    private menuService : MenuService

  ) { }

  ngOnInit() {
    this.resetActiveMenu();
    this.loadData();

  }

  previousPage() {
    this.page--;
    this.loadData();
  }

  nextPage() {
    this.page++;
    this.loadData();
  }


  loadData(){
    this.menuService.getMenusPaged(this.page, this.size).subscribe(
      res =>{
        this.menus = res.content;
        this.last = res.last;

      }

    );
   this.getCategories();
  }

  getCategories(){
    this.categoryService.getCategories().subscribe(
      categories => this.categories = categories
    )
  }

  search(name : string){
    this.menuService.searchMenu(name).subscribe((menus: Menu[]) => this.menus = menus);
  }

  addMenu(menu : Menu){
    this.menuService.postMenu(menu).subscribe(res => this.loadData())
  }


  deleteMenu(id : number){
    this.menuService.deleteMenu(id).subscribe(res => this.loadData());
  }

  editMenu(menu: Menu) {
    this.menuService.putMenu(menu).subscribe(res => {
      this.resetActiveMenu();
      this.loadData();
      this.toAdd = !this.toAdd;

    })
  }

setActiveMenu(menu : Menu){
    this.toAdd= true;
    this.activeMenu= new Menu(menu);
  }

resetActiveMenu(){
    this.toAdd= false;
  this.activeMenu = new Menu({
    name : '',
    category: new Category({
      name : '',
    }),
    price : 0
  })
}


}
