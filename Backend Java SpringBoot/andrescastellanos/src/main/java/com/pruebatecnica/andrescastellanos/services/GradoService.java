package com.pruebatecnica.andrescastellanos.services;

import org.springframework.http.ResponseEntity;
import com.pruebatecnica.andrescastellanos.entities.GradoEntity;
import com.pruebatecnica.andrescastellanos.responses.GradoResponse;

public interface GradoService {

  ResponseEntity<GradoResponse> getGrado();
  ResponseEntity<GradoResponse> createEditGrado(GradoEntity grado);
  ResponseEntity<GradoResponse> removeGrado(Integer idGrado);

}
