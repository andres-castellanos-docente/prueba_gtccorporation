export class GradosModel {
  id: number;
  descripcion: string;


  constructor(json: any = null, ed: boolean) {
    if (json !== null) {
      this.id = json.id;
      this.descripcion = json.descripcion;

    } else {
      this.id = null;
      this.descripcion = null;
    }
  }
}
