import { Component, OnInit } from '@angular/core';
import {subirAnimation} from "../../../animations/listanim.animations";
import {AppCargandoService} from "../../../appBase/cargando/app.cargando.service";
import {HomeService} from "../../services/home.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  animations: [subirAnimation]
})
export class HomeComponent implements OnInit {

  constructor(private homeService: HomeService, private cargServ: AppCargandoService) { }

  ngOnInit(): void {
  }

}
