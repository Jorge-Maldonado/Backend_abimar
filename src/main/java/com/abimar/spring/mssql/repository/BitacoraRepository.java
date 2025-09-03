package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Bitacora;

public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {
}
