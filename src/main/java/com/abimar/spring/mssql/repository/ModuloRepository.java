package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
}
