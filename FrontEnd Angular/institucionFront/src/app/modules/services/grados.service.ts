import {Injectable, SkipSelf} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {GradosModel} from "../models/grados.model";

@Injectable({
  providedIn: 'root'
})
export class GradosService {

  constructor( private http: HttpClient) {
  }

  path = 'grado';

  listarGrados(): Observable<any> {
    return this.http.get(environment.apiUrl + this.path, {});
  }

  crearGrado(request: GradosModel): Observable<any> {
    return this.http.post(environment.apiUrl + this.path, request, {});
  }

  editarGrado(request: GradosModel): Observable<any> {
    return this.http.put(environment.apiUrl + this.path, request, {});
  }

  eliminarGrado(idElim: number): Observable<any> {
    return this.http.delete(environment.apiUrl + this.path + '/' + idElim.toString(), {});
  }

}
