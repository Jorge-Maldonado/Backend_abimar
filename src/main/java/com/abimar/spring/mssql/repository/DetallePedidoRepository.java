package com.abimar.spring.mssql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    List<DetallePedido> findByPedidoId(Long pedidoId);
}
