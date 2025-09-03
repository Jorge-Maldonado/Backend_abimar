package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
