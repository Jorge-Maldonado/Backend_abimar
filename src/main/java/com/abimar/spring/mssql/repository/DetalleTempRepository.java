package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.DetalleTemp;

public interface DetalleTempRepository extends JpaRepository<DetalleTemp, Long> {
}
