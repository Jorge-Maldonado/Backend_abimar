package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Reembolso;

public interface ReembolsoRepository extends JpaRepository<Reembolso, Long> {
}
