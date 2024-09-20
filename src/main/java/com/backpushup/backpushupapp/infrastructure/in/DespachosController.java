package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.DespachosService;
import com.backpushup.backpushupapp.domain.Despachos;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Despachos")
public class DespachosController {

    private final DespachosService DespachosService;

    public DespachosController(DespachosService DespachosService) {
        this.DespachosService = DespachosService;
    }

    @GetMapping
    public List<Despachos> getAllDespachoss() {
        return DespachosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despachos> getDespachosById(@PathVariable Long id) {
        Optional<Despachos> foundDespachos = DespachosService.findById(id);
        if (!foundDespachos.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundDespachos.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Despachos> createDespachos(@Valid @RequestBody Despachos Despachos) {
        DespachosService.save(Despachos);
        return new ResponseEntity<>(Despachos, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDespachos(@PathVariable Long id, @Valid @RequestBody Despachos Despachos) {
        Optional<Despachos> existingDespachos = DespachosService.findById(id);
        if (!existingDespachos.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Despachos.setId(id);
        DespachosService.save(Despachos);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Despachos actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDespachos(@PathVariable Long id) {
        Optional<Despachos> foundDespachos = DespachosService.findById(id);
        if (!foundDespachos.isPresent()){
            return new ResponseEntity<>("Despachos no encontrado", HttpStatus.NOT_FOUND);
        }
        DespachosService.deleteById(id);
        return new ResponseEntity<>("Despachos eliminado correctamente", HttpStatus.OK);
    }
}
