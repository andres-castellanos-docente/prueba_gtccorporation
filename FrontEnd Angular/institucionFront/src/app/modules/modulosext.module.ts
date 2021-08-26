import { NgModule } from '@angular/core';
import { ModulosextRoutingModule } from './modulosext-routing.module';
import { HomeComponent } from './formas/home/home.component';
import { GradoComponent } from './formas/grado/grado.component';
import {SharedModule} from "../SharedModule";
import {DialogMessagesComponent} from "./formas/grado/diagmessages.component";
import {DialogConfElimComponent} from "./formas/grado/diagconfelim.component";
import {DialogCreatGradoComponent} from "./formas/grado/dialog-creat-grado/dialog-creat-grado.component";

@NgModule({
  imports: [
    ModulosextRoutingModule,
    SharedModule
  ],
  declarations: [
    HomeComponent,
    DialogMessagesComponent,
    DialogConfElimComponent,
    DialogCreatGradoComponent,
    GradoComponent
  ],
  entryComponents: []
})
export class ModulosextModule { }
