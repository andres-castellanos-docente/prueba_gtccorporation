import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AppCargandoService} from '../../../appBase/cargando/app.cargando.service';
import {DialogMessagesComponent} from './diagmessages.component';
import {GradosService} from "../../services/grados.service";
import {CreateEdGradoResponse} from "../../responses/listResponses";



@Component({
  selector: 'app-diagconfelim-component',
  templateUrl: 'diagconfelim.component.html'
})
export class DialogConfElimComponent {
  message: string;
  IdGradoElim: number;

  constructor(public dialog: MatDialog, private gradosService: GradosService, private cargServ: AppCargandoService,
              public dialogRef: MatDialogRef<DialogConfElimComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
    this.message = data.message;
    this.IdGradoElim = data.IdGradoElim;
  }

  public Cerrar(resultad: boolean): void {
    let resultado: any;
    if (resultad === true) {
      resultado = {result: resultad};
    } else {
      resultado = {result: resultad};
    }
    this.dialogRef.close(resultado);
  }

  public Aceptar(): void {
    this.cargServ.iniciarCargando();
    debugger;
    this.gradosService.eliminarGrado(this.IdGradoElim).subscribe((res: Response) => {
      const response: CreateEdGradoResponse = res as any;
      this.cargServ.detenCargando();

      if (response.responseCode === 1) {
        this.Cerrar(true);
      } else {
        this.dialog.open(DialogMessagesComponent, {
          minWidth: '320px',
          maxWidth: '632px',
          data: {message: response.responseDescription + ' 😅'}
        });
        this.Cerrar(false);
      }
    });
  }

}

