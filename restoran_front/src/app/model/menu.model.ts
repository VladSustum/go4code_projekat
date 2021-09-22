import {Category} from './category.model'

export interface MenuInterface {
    id?: number;
    name: string;
    category: Category;
    price: number;
}


export class Menu implements MenuInterface{
    public id? : number;
    public name : string;
    public category: Category;
    public price: number;


    constructor(menuCfg : MenuInterface){
        this.id = menuCfg.id;
        this.name = menuCfg.name;
        this.category= menuCfg.category;
        this.price= menuCfg.price;
    }




}
export interface menuDTO{
    menu : Menu;
    index: number;
}