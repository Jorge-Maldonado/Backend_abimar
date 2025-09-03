package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
