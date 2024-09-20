package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.GeneroService;
import com.backpushup.backpushupapp.domain.Genero;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Genero")
public class GeneroController {

    private final GeneroService GeneroService;

    public GeneroController(GeneroService GeneroService) {
        this.GeneroService = GeneroService;
    }

    @GetMapping
    public List<Genero> getAllGeneros() {
        return GeneroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Long id) {
        Optional<Genero> foundGenero = GeneroService.findById(id);
        if (!foundGenero.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundGenero.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genero> createGenero(@Valid @RequestBody Genero Genero) {
        GeneroService.save(Genero);
        return new ResponseEntity<>(Genero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateGenero(@PathVariable Long id, @Valid @RequestBody Genero Genero) {
        Optional<Genero> existingGenero = GeneroService.findById(id);
        if (!existingGenero.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Genero.setId(id);
        GeneroService.save(Genero);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Genero actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenero(@PathVariable Long id) {
        Optional<Genero> foundGenero = GeneroService.findById(id);
        if (!foundGenero.isPresent()){
            return new ResponseEntity<>("Genero no encontrado", HttpStatus.NOT_FOUND);
        }
        GeneroService.deleteById(id);
        return new ResponseEntity<>("Genero eliminado correctamente", HttpStatus.OK);
    }
}
