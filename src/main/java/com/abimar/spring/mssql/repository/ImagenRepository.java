package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
