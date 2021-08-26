import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AppprincComponent} from "./appBase/princ/appprinc.component";
import {AppFooterComponent} from "./appBase/footer/app.footer.component";
import {AppMenuComponent, AppSubMenuComponent} from "./appBase/menu/app.menu.component";
import {AppBreadCrumbComponent} from "./appBase/breadcrumb/app.breadcrumb.component";
import {AppCargandoComponent} from "./appBase/cargando/app.cargando.component";
import {AppTopBarComponent} from "./appBase/topbar/app.topbar.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppCargandoService} from "./appBase/cargando/app.cargando.service";
import {XsegundoService} from "./appBase/breadcrumb/xsegundo.service";
import {SharedModule} from "./SharedModule";

@NgModule({
  declarations: [
    AppComponent,
    AppCargandoComponent,
    AppTopBarComponent,
    AppBreadCrumbComponent,
    AppMenuComponent,
    AppSubMenuComponent,
    AppFooterComponent,
    AppprincComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [XsegundoService, AppCargandoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
