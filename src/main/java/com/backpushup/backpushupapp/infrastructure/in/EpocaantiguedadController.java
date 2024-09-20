package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.EpocaantiguedadService;
import com.backpushup.backpushupapp.domain.Epocaantiguedad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Epocaantiguedad")
public class EpocaantiguedadController {

    private final EpocaantiguedadService EpocaantiguedadService;

    public EpocaantiguedadController(EpocaantiguedadService EpocaantiguedadService) {
        this.EpocaantiguedadService = EpocaantiguedadService;
    }

    @GetMapping
    public List<Epocaantiguedad> getAllEpocaantiguedads() {
        return EpocaantiguedadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Epocaantiguedad> getEpocaantiguedadById(@PathVariable Long id) {
        Optional<Epocaantiguedad> foundEpocaantiguedad = EpocaantiguedadService.findById(id);
        if (!foundEpocaantiguedad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundEpocaantiguedad.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Epocaantiguedad> createEpocaantiguedad(@Valid @RequestBody Epocaantiguedad Epocaantiguedad) {
        EpocaantiguedadService.save(Epocaantiguedad);
        return new ResponseEntity<>(Epocaantiguedad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateEpocaantiguedad(@PathVariable Long id, @Valid @RequestBody Epocaantiguedad Epocaantiguedad) {
        Optional<Epocaantiguedad> existingEpocaantiguedad = EpocaantiguedadService.findById(id);
        if (!existingEpocaantiguedad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Epocaantiguedad.setId(id);
        EpocaantiguedadService.save(Epocaantiguedad);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Epocaantiguedad actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEpocaantiguedad(@PathVariable Long id) {
        Optional<Epocaantiguedad> foundEpocaantiguedad = EpocaantiguedadService.findById(id);
        if (!foundEpocaantiguedad.isPresent()){
            return new ResponseEntity<>("Epocaantiguedad no encontrado", HttpStatus.NOT_FOUND);
        }
        EpocaantiguedadService.deleteById(id);
        return new ResponseEntity<>("Epocaantiguedad eliminado correctamente", HttpStatus.OK);
    }
}
