package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.HistorialpropiedadService;
import com.backpushup.backpushupapp.domain.Historialpropiedad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Historialpropiedad")
public class HistorialpropiedadController {

    private final HistorialpropiedadService HistorialpropiedadService;

    public HistorialpropiedadController(HistorialpropiedadService HistorialpropiedadService) {
        this.HistorialpropiedadService = HistorialpropiedadService;
    }

    @GetMapping
    public List<Historialpropiedad> getAllHistorialpropiedads() {
        return HistorialpropiedadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historialpropiedad> getHistorialpropiedadById(@PathVariable Long id) {
        Optional<Historialpropiedad> foundHistorialpropiedad = HistorialpropiedadService.findById(id);
        if (!foundHistorialpropiedad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundHistorialpropiedad.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Historialpropiedad> createHistorialpropiedad(@Valid @RequestBody Historialpropiedad Historialpropiedad) {
        HistorialpropiedadService.save(Historialpropiedad);
        return new ResponseEntity<>(Historialpropiedad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateHistorialpropiedad(@PathVariable Long id, @Valid @RequestBody Historialpropiedad Historialpropiedad) {
        Optional<Historialpropiedad> existingHistorialpropiedad = HistorialpropiedadService.findById(id);
        if (!existingHistorialpropiedad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Historialpropiedad.setId(id);
        HistorialpropiedadService.save(Historialpropiedad);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Historialpropiedad actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistorialpropiedad(@PathVariable Long id) {
        Optional<Historialpropiedad> foundHistorialpropiedad = HistorialpropiedadService.findById(id);
        if (!foundHistorialpropiedad.isPresent()){
            return new ResponseEntity<>("Historialpropiedad no encontrado", HttpStatus.NOT_FOUND);
        }
        HistorialpropiedadService.deleteById(id);
        return new ResponseEntity<>("Historialpropiedad eliminado correctamente", HttpStatus.OK);
    }
}
