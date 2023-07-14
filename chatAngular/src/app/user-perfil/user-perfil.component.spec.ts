import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPerfilComponent } from './user-perfil.component';

describe('UserPerfilComponent', () => {
  let component: UserPerfilComponent;
  let fixture: ComponentFixture<UserPerfilComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserPerfilComponent]
    });
    fixture = TestBed.createComponent(UserPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
