import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AppCargandoService} from '../../../../appBase/cargando/app.cargando.service';
import {GradosService} from '../../../services/grados.service';
import {DialogMessagesComponent} from '../diagmessages.component';
import {GradosModel} from "../../../models/grados.model";
import {CreateEdGradoResponse} from "../../../responses/listResponses";

@Component({
  selector: 'app-dialog-creat-usuarios',
  templateUrl: './dialog-creat-grado.component.html',
  styleUrls: ['./dialog-creat-grado.component.scss']
})
export class DialogCreatGradoComponent implements OnInit {
  gradoForm: FormGroup;
  dataAdEd: GradosModel;
  selectedGrado: GradosModel;
  usuarioSubmited: boolean;

  constructor(public dialog: MatDialog, private builder: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data: any, private cargServ: AppCargandoService,
              public dialogRef: MatDialogRef<DialogCreatGradoComponent>,
              private gradosService: GradosService) {

    if (data.dataed === null) {
      this.selectedGrado = new GradosModel(null, false);
    } else {
      this.selectedGrado = new GradosModel(data.dataed, false);
    }

  }

  ngOnInit(): void {
    this.gradoForm = this.builder.group({
      id: [this.selectedGrado.id, []],
      descripcion: [this.selectedGrado.descripcion, [Validators.required, Validators.maxLength(80)]],
    });
  }

  isBase64(str): boolean {
    try {
      return btoa(atob(str)) == str;
    } catch (err) {
      return false;
    }
  }

  onSubmitCrear(): void {
    this.usuarioSubmited = true;
    if (this.gradoForm.invalid) {
      return;
    }
    const gradoModelEnv = new GradosModel(this.gradoForm.value, true);
    this.cargServ.iniciarCargando();
    if (this.data.dataed === null) {
      this.gradosService.crearGrado(gradoModelEnv).subscribe((res: Response) => {
        const response: CreateEdGradoResponse = res as any;
        this.cargServ.detenCargando();
        if (response.responseCode === 1) {
          this.dataAdEd = response.grado;
          this.Close(true);
        } else {
          this.dialog.open(DialogMessagesComponent, {
            minWidth: '320px',
            maxWidth: '632px',
            data: {message: 'Ocurrió un error al Crear el Grado 😅'}
          });
          this.Close(false);
        }
      });
    } else {
      this.gradosService.editarGrado(gradoModelEnv).subscribe((res: Response) => {
        const response: CreateEdGradoResponse = res as any;
        this.cargServ.detenCargando();
        if (response.responseCode === 1) {
          this.dataAdEd = response.grado;
          this.Close(true);
        } else {
          this.dialog.open(DialogMessagesComponent, {
            minWidth: '320px',
            maxWidth: '632px',
            data: {message: 'Ocurrió un error al Editar el Grado 😅'}
          });
          this.Close(false);
        }
      });
    }
  }

  public Close(resultad: boolean): void {
    let resultado: any;

    if (resultad === true) {
      resultado = {result: resultad, dataAdEd: this.dataAdEd};
    } else {
      resultado = {result: resultad, dataAdEd: null};
    }
    this.dialogRef.close(resultado);
  }
}
