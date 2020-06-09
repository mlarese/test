import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteEditComponent } from './cliente-edit.component';
import { ClienteEditRoutingModule } from './cliente-edit-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    ClienteEditRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    ClienteEditComponent
  ]
})
export class ClienteEditModule { }
