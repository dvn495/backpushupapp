package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.ClasecontactoService;
import com.backpushup.backpushupapp.domain.Clasecontacto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Clasecontacto")
public class ClasecontactoController {

    private final ClasecontactoService ClasecontactoService;

    public ClasecontactoController(ClasecontactoService ClasecontactoService) {
        this.ClasecontactoService = ClasecontactoService;
    }

    @GetMapping
    public List<Clasecontacto> getAllClasecontactos() {
        return ClasecontactoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clasecontacto> getClasecontactoById(@PathVariable Long id) {
        Optional<Clasecontacto> foundClasecontacto = ClasecontactoService.findById(id);
        if (!foundClasecontacto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundClasecontacto.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Clasecontacto> createClasecontacto(@Valid @RequestBody Clasecontacto Clasecontacto) {
        ClasecontactoService.save(Clasecontacto);
        return new ResponseEntity<>(Clasecontacto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateClasecontacto(@PathVariable Long id, @Valid @RequestBody Clasecontacto Clasecontacto) {
        Optional<Clasecontacto> existingClasecontacto = ClasecontactoService.findById(id);
        if (!existingClasecontacto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Clasecontacto.setId(id);
        ClasecontactoService.save(Clasecontacto);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Clasecontacto actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClasecontacto(@PathVariable Long id) {
        Optional<Clasecontacto> foundClasecontacto = ClasecontactoService.findById(id);
        if (!foundClasecontacto.isPresent()){
            return new ResponseEntity<>("Clasecontacto no encontrado", HttpStatus.NOT_FOUND);
        }
        ClasecontactoService.deleteById(id);
        return new ResponseEntity<>("Clasecontacto eliminado correctamente", HttpStatus.OK);
    }
}
