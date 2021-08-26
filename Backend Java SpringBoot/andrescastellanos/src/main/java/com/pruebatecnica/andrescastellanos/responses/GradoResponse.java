package com.pruebatecnica.andrescastellanos.responses;

import java.util.List;
import com.pruebatecnica.andrescastellanos.entities.GradoEntity;

public class GradoResponse extends ResponseGen {

  List<GradoEntity> grado;

  public GradoResponse (Integer responseCode, List<String> responseDescription, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
  }

  public GradoResponse (Integer responseCode, List<String> responseDescription,List<GradoEntity> grado, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
    setGrado(grado);
  }

  public void setGrado(List<GradoEntity> grado){
    this.grado = grado;
  }

  public List<GradoEntity>  getGrado() {
    return grado;
  }

}
