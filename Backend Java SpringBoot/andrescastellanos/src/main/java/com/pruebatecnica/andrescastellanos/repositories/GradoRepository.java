package com.pruebatecnica.andrescastellanos.repositories;

import com.pruebatecnica.andrescastellanos.entities.GradoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoRepository extends JpaRepository<GradoEntity,Integer> {

}
