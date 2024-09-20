package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.ColeccionistasService;
import com.backpushup.backpushupapp.domain.Coleccionistas;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Coleccionistas")
public class ColeccionistasController {

    private final ColeccionistasService ColeccionistasService;

    public ColeccionistasController(ColeccionistasService ColeccionistasService) {
        this.ColeccionistasService = ColeccionistasService;
    }

    @GetMapping
    public List<Coleccionistas> getAllColeccionistass() {
        return ColeccionistasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coleccionistas> getColeccionistasById(@PathVariable Long id) {
        Optional<Coleccionistas> foundColeccionistas = ColeccionistasService.findById(id);
        if (!foundColeccionistas.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundColeccionistas.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coleccionistas> createColeccionistas(@Valid @RequestBody Coleccionistas Coleccionistas) {
        ColeccionistasService.save(Coleccionistas);
        return new ResponseEntity<>(Coleccionistas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateColeccionistas(@PathVariable Long id, @Valid @RequestBody Coleccionistas Coleccionistas) {
        Optional<Coleccionistas> existingColeccionistas = ColeccionistasService.findById(id);
        if (!existingColeccionistas.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Coleccionistas.setId(id);
        ColeccionistasService.save(Coleccionistas);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Coleccionistas actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteColeccionistas(@PathVariable Long id) {
        Optional<Coleccionistas> foundColeccionistas = ColeccionistasService.findById(id);
        if (!foundColeccionistas.isPresent()){
            return new ResponseEntity<>("Coleccionistas no encontrado", HttpStatus.NOT_FOUND);
        }
        ColeccionistasService.deleteById(id);
        return new ResponseEntity<>("Coleccionistas eliminado correctamente", HttpStatus.OK);
    }
}
