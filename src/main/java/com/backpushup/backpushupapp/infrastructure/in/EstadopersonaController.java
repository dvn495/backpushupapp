package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.EstadopersonaService;
import com.backpushup.backpushupapp.domain.Estadopersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Estadopersona")
public class EstadopersonaController {

    private final EstadopersonaService EstadopersonaService;

    public EstadopersonaController(EstadopersonaService EstadopersonaService) {
        this.EstadopersonaService = EstadopersonaService;
    }

    @GetMapping
    public List<Estadopersona> getAllEstadopersonas() {
        return EstadopersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadopersona> getEstadopersonaById(@PathVariable Long id) {
        Optional<Estadopersona> foundEstadopersona = EstadopersonaService.findById(id);
        if (!foundEstadopersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundEstadopersona.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estadopersona> createEstadopersona(@Valid @RequestBody Estadopersona Estadopersona) {
        EstadopersonaService.save(Estadopersona);
        return new ResponseEntity<>(Estadopersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateEstadopersona(@PathVariable Long id, @Valid @RequestBody Estadopersona Estadopersona) {
        Optional<Estadopersona> existingEstadopersona = EstadopersonaService.findById(id);
        if (!existingEstadopersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Estadopersona.setId(id);
        EstadopersonaService.save(Estadopersona);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Estadopersona actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstadopersona(@PathVariable Long id) {
        Optional<Estadopersona> foundEstadopersona = EstadopersonaService.findById(id);
        if (!foundEstadopersona.isPresent()){
            return new ResponseEntity<>("Estadopersona no encontrado", HttpStatus.NOT_FOUND);
        }
        EstadopersonaService.deleteById(id);
        return new ResponseEntity<>("Estadopersona eliminado correctamente", HttpStatus.OK);
    }
}
