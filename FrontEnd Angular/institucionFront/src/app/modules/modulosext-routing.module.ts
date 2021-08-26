import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./formas/home/home.component";
import {GradoComponent} from "./formas/grado/grado.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent, canActivate: []},
  {path: 'grados', component: GradoComponent, canActivate: []},
  {path: '', redirectTo: 'grados', pathMatch: 'full', canActivate: []}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ModulosextRoutingModule {
}
