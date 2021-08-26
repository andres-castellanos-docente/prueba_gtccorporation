import {GradosModel} from '../models/grados.model';


export interface CreateEdGradoResponse {
    responseCode: number;
    grado: GradosModel;
  responseDescription: string;
}

