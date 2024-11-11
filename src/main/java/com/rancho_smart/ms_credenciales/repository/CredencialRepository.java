package com.rancho_smart.ms_credenciales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_credenciales.entity.Credencial;
import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, Long>{
    public Optional<Credencial> findByIdUsuario(Long idUsuario);
    public Optional<Credencial> findByUsername(String username);
}
