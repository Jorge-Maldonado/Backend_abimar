package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Suscripciones;

public interface SuscripcionesRepository extends JpaRepository<Suscripciones, Long> {
}
