package com.rancho_smart.ms_credenciales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_credenciales.entity.Credencial;

public interface CredencialRepository extends JpaRepository<Credencial, Long>{
    
}
