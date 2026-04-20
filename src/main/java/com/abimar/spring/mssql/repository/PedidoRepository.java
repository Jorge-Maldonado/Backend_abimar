package com.abimar.spring.mssql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByPersonal(Long personal);
}
