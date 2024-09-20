package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.PaisesService;
import com.backpushup.backpushupapp.domain.Paises;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Paises")
public class PaisesController {

    private final PaisesService PaisesService;

    public PaisesController(PaisesService PaisesService) {
        this.PaisesService = PaisesService;
    }

    @GetMapping
    public List<Paises> getAllPaisess() {
        return PaisesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paises> getPaisesById(@PathVariable Long id) {
        Optional<Paises> foundPaises = PaisesService.findById(id);
        if (!foundPaises.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPaises.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Paises> createPaises(@Valid @RequestBody Paises Paises) {
        PaisesService.save(Paises);
        return new ResponseEntity<>(Paises, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updatePaises(@PathVariable Long id, @Valid @RequestBody Paises Paises) {
        Optional<Paises> existingPaises = PaisesService.findById(id);
        if (!existingPaises.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Paises.setId(id);
        PaisesService.save(Paises);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Paises actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaises(@PathVariable Long id) {
        Optional<Paises> foundPaises = PaisesService.findById(id);
        if (!foundPaises.isPresent()){
            return new ResponseEntity<>("Paises no encontrado", HttpStatus.NOT_FOUND);
        }
        PaisesService.deleteById(id);
        return new ResponseEntity<>("Paises eliminado correctamente", HttpStatus.OK);
    }
}
