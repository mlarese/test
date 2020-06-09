import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteListComponent } from './cliente-list.component';
import { ClienteListRoutingModule } from './cliente-list-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    ClienteListRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    ClienteListComponent
  ]
})
export class ClienteListModule { }
