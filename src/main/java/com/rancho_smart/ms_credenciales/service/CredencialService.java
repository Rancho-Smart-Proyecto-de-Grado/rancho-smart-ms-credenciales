package com.rancho_smart.ms_credenciales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_credenciales.entity.Credencial;
import com.rancho_smart.ms_credenciales.repository.CredencialRepository;

@Service
public class CredencialService {
        @Autowired
    private CredencialRepository credencialRepository;

    public List<Credencial> getCredenciales() {
        return this.credencialRepository.findAll();
    }

    public Optional<Credencial> getCredencialById(Long id) {
        return this.credencialRepository.findById(id);
    }

    public Credencial saveCredencial(Credencial credencial) {
        return this.credencialRepository.save(credencial);
    }

    public void deleteCredencial(Long id) {
        this.credencialRepository.deleteById(id);
    }
}
