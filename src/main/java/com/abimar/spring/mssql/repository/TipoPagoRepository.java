package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.TipoPago;

public interface TipoPagoRepository extends JpaRepository<TipoPago, Long> {
}
