package com.rancho_smart.ms_credenciales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_credenciales.entity.Credencial;
import com.rancho_smart.ms_credenciales.service.CredencialService;

@RestController
@RequestMapping(path = "/credenciales")
public class CredencialRESTController {
        
    @Autowired
    private CredencialService credencialService;

    @GetMapping
    public ResponseEntity<List<Credencial>> getAllCredenciales() {
        List<Credencial> listado = this.credencialService.getCredenciales();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credencial> getCredencialById(@PathVariable Long id) {
        Optional<Credencial> credencial = this.credencialService.getCredencialById(id);
        return credencial.map(ResponseEntity::ok)
                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Credencial> saveCredencial(@RequestBody Credencial credencial) {
        Credencial credencialCreada = this.credencialService.saveCredencial(credencial);
        return new ResponseEntity<>(credencialCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credencial> updateCredencial(@PathVariable Long id, @RequestBody Credencial credencial) {
        if (!this.credencialService.getCredencialById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            credencial.setIdCredencial(id);
            Credencial credencialActualizada = this.credencialService.saveCredencial(credencial);
            return new ResponseEntity<>(credencialActualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredencial(@PathVariable Long id) {
        if (!this.credencialService.getCredencialById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.credencialService.deleteCredencial(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
