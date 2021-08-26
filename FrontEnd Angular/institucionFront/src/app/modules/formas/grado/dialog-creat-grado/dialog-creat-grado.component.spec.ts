import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogCreatGradoComponent } from './dialog-creat-grado.component';

describe('DialogCreatUsuariosComponent', () => {
  let component: DialogCreatGradoComponent;
  let fixture: ComponentFixture<DialogCreatGradoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogCreatGradoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogCreatGradoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
