import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteEditComponent } from './cliente-edit.component';

const routes: Routes = [
  {
    path: '',
    component: ClienteEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClienteEditRoutingModule { }
