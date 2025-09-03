package com.abimar.spring.mssql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abimar.spring.mssql.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
  List<Persona> findByIdentificacion(int identificacion);
  List<Persona> findByNombres(String nombres);
}
