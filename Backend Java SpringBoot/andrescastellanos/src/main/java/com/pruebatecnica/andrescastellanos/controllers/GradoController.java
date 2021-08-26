package com.pruebatecnica.andrescastellanos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.pruebatecnica.andrescastellanos.responses.GradoResponse;
import com.pruebatecnica.andrescastellanos.repositories.GradoRepository;
import com.pruebatecnica.andrescastellanos.entities.GradoEntity;
import com.pruebatecnica.andrescastellanos.services.GradoService;


@RestController
public class GradoController {

  @Autowired
  private GradoService gradoService;

  @GetMapping("/grado")
  public ResponseEntity<GradoResponse> getGrado() {
     return gradoService.getGrado();
  }

  @PostMapping("/grado")
  public ResponseEntity<GradoResponse> addGrado(@RequestBody GradoEntity grado) {
     return gradoService.createEditGrado(grado);
  }

  @PutMapping("/grado")
  public ResponseEntity<GradoResponse> editGrado(@RequestBody GradoEntity grado) {
     return gradoService.createEditGrado(grado);
  }

  @DeleteMapping("/grado/{id}")
  public ResponseEntity<GradoResponse> delGrado(@PathVariable(value = "id") Integer idGrado) {
     return gradoService.removeGrado(idGrado);
  }

}
