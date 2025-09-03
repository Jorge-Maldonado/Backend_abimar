package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
