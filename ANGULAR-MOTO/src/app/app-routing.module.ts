import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminComponent} from "./components/admin/admin.component";
import { HomeComponent} from "./components/home/home.component";
import { ViewRegistrationComponent} from "./components/view-registration/view-registration.component";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'list/view/:id',
    component: ViewRegistrationComponent
  },
  {
    path: 'list',
    component: AdminComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
