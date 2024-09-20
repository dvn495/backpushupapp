package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.EmpresaService;
import com.backpushup.backpushupapp.domain.Empresa;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Empresa")
public class EmpresaController {

    private final EmpresaService EmpresaService;

    public EmpresaController(EmpresaService EmpresaService) {
        this.EmpresaService = EmpresaService;
    }

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return EmpresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id) {
        Optional<Empresa> foundEmpresa = EmpresaService.findById(id);
        if (!foundEmpresa.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundEmpresa.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@Valid @RequestBody Empresa Empresa) {
        EmpresaService.save(Empresa);
        return new ResponseEntity<>(Empresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateEmpresa(@PathVariable Long id, @Valid @RequestBody Empresa Empresa) {
        Optional<Empresa> existingEmpresa = EmpresaService.findById(id);
        if (!existingEmpresa.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Empresa.setId(id);
        EmpresaService.save(Empresa);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Empresa actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
        Optional<Empresa> foundEmpresa = EmpresaService.findById(id);
        if (!foundEmpresa.isPresent()){
            return new ResponseEntity<>("Empresa no encontrado", HttpStatus.NOT_FOUND);
        }
        EmpresaService.deleteById(id);
        return new ResponseEntity<>("Empresa eliminado correctamente", HttpStatus.OK);
    }
}
