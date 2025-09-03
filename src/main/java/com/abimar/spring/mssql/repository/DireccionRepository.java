package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
