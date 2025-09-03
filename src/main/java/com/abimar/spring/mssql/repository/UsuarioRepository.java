package com.abimar.spring.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abimar.spring.mssql.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
