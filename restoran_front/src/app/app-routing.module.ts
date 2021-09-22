import { MenuListItemComponent } from "./menu-list-item/menu-list-item.component";
import { MenusPageComponent } from "./menus-page/menus-page.component";
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";
import { MenuListComponent } from "./menu-list/menu-list.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";



const routes: Routes = [
    { path: 'menus', component: MenusPageComponent},
    { path: 'menus/:id', component: MenuListItemComponent},
    { path: '', redirectTo: 'menus', pathMatch: 'full'},
    { path: '**', component: PageNotFoundComponent}

]


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}
