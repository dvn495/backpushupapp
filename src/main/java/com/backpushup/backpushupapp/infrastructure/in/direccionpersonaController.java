package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.DireccionpersonaService;
import com.backpushup.backpushupapp.domain.DireccionPersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/DireccionPersona")
public class DireccionPersonaController {

    private final DireccionpersonaService DireccionpersonaService;

    public DireccionPersonaController(DireccionpersonaService DireccionpersonaService) {
        this.DireccionpersonaService = DireccionpersonaService;
    }

    @GetMapping
    public List<DireccionPersona> getAllDireccionPersonas() {
        return DireccionpersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionPersona> getDireccionPersonaById(@PathVariable Long id) {
        Optional<DireccionPersona> foundDireccionPersona = DireccionpersonaService.findById(id);
        if (!foundDireccionPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundDireccionPersona.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DireccionPersona> createDireccionPersona(@Valid @RequestBody DireccionPersona DireccionPersona) {
        DireccionpersonaService.save(DireccionPersona);
        return new ResponseEntity<>(DireccionPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDireccionPersona(@PathVariable Long id, @Valid @RequestBody DireccionPersona DireccionPersona) {
        Optional<DireccionPersona> existingDireccionPersona = DireccionpersonaService.findById(id);
        if (!existingDireccionPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DireccionPersona.setId(id);
        DireccionpersonaService.save(DireccionPersona);
        Map<String, String> response = new HashMap<>();
        response.put("message", "DireccionPersona actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDireccionPersona(@PathVariable Long id) {
        Optional<DireccionPersona> foundDireccionPersona = DireccionpersonaService.findById(id);
        if (!foundDireccionPersona.isPresent()){
            return new ResponseEntity<>("DireccionPersona no encontrado", HttpStatus.NOT_FOUND);
        }
        DireccionpersonaService.deleteById(id);
        return new ResponseEntity<>("DireccionPersona eliminado correctamente", HttpStatus.OK);
    }
}
