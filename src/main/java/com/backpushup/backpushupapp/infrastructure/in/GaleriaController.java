package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.GaleriaService;
import com.backpushup.backpushupapp.domain.Galeria;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Galeria")
public class GaleriaController {

    private final GaleriaService GaleriaService;

    public GaleriaController(GaleriaService GaleriaService) {
        this.GaleriaService = GaleriaService;
    }

    @GetMapping
    public List<Galeria> getAllGalerias() {
        return GaleriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Galeria> getGaleriaById(@PathVariable Long id) {
        Optional<Galeria> foundGaleria = GaleriaService.findById(id);
        if (!foundGaleria.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundGaleria.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Galeria> createGaleria(@Valid @RequestBody Galeria Galeria) {
        GaleriaService.save(Galeria);
        return new ResponseEntity<>(Galeria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateGaleria(@PathVariable Long id, @Valid @RequestBody Galeria Galeria) {
        Optional<Galeria> existingGaleria = GaleriaService.findById(id);
        if (!existingGaleria.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Galeria.setId(id);
        GaleriaService.save(Galeria);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Galeria actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGaleria(@PathVariable Long id) {
        Optional<Galeria> foundGaleria = GaleriaService.findById(id);
        if (!foundGaleria.isPresent()){
            return new ResponseEntity<>("Galeria no encontrado", HttpStatus.NOT_FOUND);
        }
        GaleriaService.deleteById(id);
        return new ResponseEntity<>("Galeria eliminado correctamente", HttpStatus.OK);
    }
}
