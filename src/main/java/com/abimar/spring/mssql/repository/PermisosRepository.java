package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Permisos;

public interface PermisosRepository extends JpaRepository<Permisos, Long> {
}
