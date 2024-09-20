package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.RegionesService;
import com.backpushup.backpushupapp.domain.Regiones;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Regiones")
public class RegionesController {

    private final RegionesService RegionesService;

    public RegionesController(RegionesService RegionesService) {
        this.RegionesService = RegionesService;
    }

    @GetMapping
    public List<Regiones> getAllRegioness() {
        return RegionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regiones> getRegionesById(@PathVariable Long id) {
        Optional<Regiones> foundRegiones = RegionesService.findById(id);
        if (!foundRegiones.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundRegiones.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Regiones> createRegiones(@Valid @RequestBody Regiones Regiones) {
        RegionesService.save(Regiones);
        return new ResponseEntity<>(Regiones, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateRegiones(@PathVariable Long id, @Valid @RequestBody Regiones Regiones) {
        Optional<Regiones> existingRegiones = RegionesService.findById(id);
        if (!existingRegiones.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Regiones.setId(id);
        RegionesService.save(Regiones);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Regiones actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegiones(@PathVariable Long id) {
        Optional<Regiones> foundRegiones = RegionesService.findById(id);
        if (!foundRegiones.isPresent()){
            return new ResponseEntity<>("Regiones no encontrado", HttpStatus.NOT_FOUND);
        }
        RegionesService.deleteById(id);
        return new ResponseEntity<>("Regiones eliminado correctamente", HttpStatus.OK);
    }
}
