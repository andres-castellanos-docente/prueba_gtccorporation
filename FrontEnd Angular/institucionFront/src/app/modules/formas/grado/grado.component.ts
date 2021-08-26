import {Component, OnInit, ViewChild} from '@angular/core';
import {subirAnimation} from "../../../animations/listanim.animations";
import {GradosModel} from "../../models/grados.model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {AppCargandoService} from "../../../appBase/cargando/app.cargando.service";
import {GradosService} from "../../services/grados.service";
import {DialogMessagesComponent} from "./diagmessages.component";
import {DialogConfElimComponent} from "./diagconfelim.component";
import {DialogCreatGradoComponent} from "./dialog-creat-grado/dialog-creat-grado.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-signup',
  templateUrl: './grado.component.html',
  styleUrls: ['./grado.component.scss'],
  animations: [subirAnimation]
})
export class GradoComponent implements OnInit {
  dataGrados: GradosModel[];
  dataSource: MatTableDataSource<GradosModel>;
  displayedColumns: string[] = ['editar', 'id', 'descripcion', 'eliminar'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  indexElEd: number;

  constructor(private gradosService: GradosService, private cargServ: AppCargandoService, public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.cargServ.iniciarCargando();

    this.gradosService.listarGrados().subscribe((res: Response) => {
      const response = res as any;
      this.dataGrados = response.grado;
      this.dataSource = new MatTableDataSource<GradosModel>(this.dataGrados);
      this.dataSource.paginator = this.paginator;
      this.cargServ.detenCargando();
    });
  }

  eliminar(UsuarioEl: GradosModel, indexEl: number): void {
    // Se debe que validar la página actual para tomar el índice correcto a eliminar
    const pagact = this.paginator.pageIndex;
    if (pagact === 0) {
      this.indexElEd = indexEl;
    } else {
      const pagsize = this.paginator.pageSize;
      this.indexElEd = (pagsize * pagact) + indexEl;
    }

    const dialogRef = this.dialog.open(DialogConfElimComponent, {
      minWidth: '320px',
      maxWidth: '532px',
      data: {message: '🤔 ¿Desea Borrar el Grado ' + UsuarioEl.descripcion + '?', IdGradoElim: UsuarioEl.id}
    });
    dialogRef.afterClosed().subscribe(result => {
      // Se verifica si es diferente de nil para evitar error que ocurre al oprimir Esc
      if (result) {
        if (result.result) {
          if ((result.result === true)) {

            this.dialog.open(DialogMessagesComponent, {
              minWidth: '320px',
              maxWidth: '532px',
              data: {message: 'Grado Eliminado 😌'}
            });
            this.dataGrados.splice(this.indexElEd, 1);
            this.dataSource = new MatTableDataSource<GradosModel>(this.dataGrados);
            this.dataSource.paginator = this.paginator;
          }
        }
      }
    });
  }

  editar(UsuarioEd: GradosModel, indexEd: number): void {
    // Se debe que validar la página actual para tomar el índice correcto a editar
    const pagact = this.paginator.pageIndex;
    if (pagact === 0) {
      this.indexElEd = indexEd;
    } else {
      const pagsize = this.paginator.pageSize;
      this.indexElEd = (pagsize * pagact) + indexEd;
    }

    const dialogRef = this.dialog.open(DialogCreatGradoComponent, {
      minWidth: '320px',
      maxWidth: '490px',
      data: {dataed: UsuarioEd}
    });
    dialogRef.afterClosed().subscribe(result => {
      // Se verifica si es diferente de nil para evitar error que ocurre al oprimir Esc
      if (result) {
        if (result.result) {
          if ((result.result === true) && (result.dataAdEd)) {
            this.dialog.open(DialogMessagesComponent, {
              minWidth: '320px',
              maxWidth: '532px',
              data: {message: 'Grado Editado 😃'}
            });
            this.dataGrados[this.indexElEd] = result.dataAdEd[0];
            this.dataSource = new MatTableDataSource<GradosModel>(this.dataGrados);
            this.dataSource.paginator = this.paginator;
          }
        }
      }
    });
  }

  createDialog(): void {
    const dialogRef = this.dialog.open(DialogCreatGradoComponent, {
      minWidth: '320px',
      maxWidth: '490px',
      data: {dataed: null}
    });

    dialogRef.afterClosed().subscribe(result => {
      // Se verifica si es diferente de nil para evitar error que ocurre al oprimir Esc
      if (result) {
        if (result.result) {
          if ((result.result === true) && (result.dataAdEd)) {
            this.dialog.open(DialogMessagesComponent, {
              minWidth: '320px',
              maxWidth: '532px',
              data: {message: 'Grado Creado 😃'}
            });
            debugger;
            this.dataGrados.push(result.dataAdEd[0]);
            this.dataSource = new MatTableDataSource<GradosModel>(this.dataGrados);
            this.dataSource.paginator = this.paginator;
          }
        }
      }
    });
  }


}
