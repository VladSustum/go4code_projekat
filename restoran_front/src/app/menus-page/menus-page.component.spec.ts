import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenusPageComponent } from './menus-page.component';

describe('MenusPageComponent', () => {
  let component: MenusPageComponent;
  let fixture: ComponentFixture<MenusPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenusPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenusPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
