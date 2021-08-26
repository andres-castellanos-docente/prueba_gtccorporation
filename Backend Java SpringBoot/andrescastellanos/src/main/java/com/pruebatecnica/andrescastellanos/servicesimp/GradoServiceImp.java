package com.pruebatecnica.andrescastellanos.servicesimp;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebatecnica.andrescastellanos.services.GradoService;
import org.springframework.http.ResponseEntity;
import com.pruebatecnica.andrescastellanos.entities.GradoEntity;
import com.pruebatecnica.andrescastellanos.responses.GradoResponse;
import com.pruebatecnica.andrescastellanos.repositories.GradoRepository;

@Service
public class GradoServiceImp implements GradoService {

@Autowired
private GradoRepository gradoRepository;

  @Override
  public ResponseEntity<GradoResponse> getGrado() {
    List<String> listMess = new ArrayList<>();
    try {
      List<GradoEntity> gradoAll = gradoRepository.findAll();
      listMess.add("Se consulta ok");
      return new ResponseEntity<>(new GradoResponse(1, listMess, gradoAll, HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al consultar");
        return new ResponseEntity<>(new GradoResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<GradoResponse> createEditGrado(GradoEntity gradoEntity) {
    List<String> listMess = new ArrayList<>();
    try {
      List<GradoEntity> listGradoSaved = new ArrayList<>();
      GradoEntity gradoSaved = gradoRepository.save(gradoEntity);
      listGradoSaved.add(gradoSaved);
      listMess.add("Se guardó ok");
      return new ResponseEntity<>(new GradoResponse(1, listMess,listGradoSaved,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al guardar");
        return new ResponseEntity<>(new GradoResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<GradoResponse> removeGrado(Integer idGrado) {
    List<String> listMess = new ArrayList<>();
    try {
      gradoRepository.deleteById(idGrado);
      listMess.add("Se elimina ok");
      return new ResponseEntity<>(new GradoResponse(1, listMess,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al eliminar");
        return new ResponseEntity<>(new GradoResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
