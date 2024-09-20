package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.TransaccionesService;
import com.backpushup.backpushupapp.domain.Transacciones;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Transacciones")
public class TransaccionesController {

    private final TransaccionesService TransaccionesService;

    public TransaccionesController(TransaccionesService TransaccionesService) {
        this.TransaccionesService = TransaccionesService;
    }

    @GetMapping
    public List<Transacciones> getAllTransaccioness() {
        return TransaccionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacciones> getTransaccionesById(@PathVariable Long id) {
        Optional<Transacciones> foundTransacciones = TransaccionesService.findById(id);
        if (!foundTransacciones.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTransacciones.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transacciones> createTransacciones(@Valid @RequestBody Transacciones Transacciones) {
        TransaccionesService.save(Transacciones);
        return new ResponseEntity<>(Transacciones, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTransacciones(@PathVariable Long id, @Valid @RequestBody Transacciones Transacciones) {
        Optional<Transacciones> existingTransacciones = TransaccionesService.findById(id);
        if (!existingTransacciones.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Transacciones.setId(id);
        TransaccionesService.save(Transacciones);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Transacciones actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransacciones(@PathVariable Long id) {
        Optional<Transacciones> foundTransacciones = TransaccionesService.findById(id);
        if (!foundTransacciones.isPresent()){
            return new ResponseEntity<>("Transacciones no encontrado", HttpStatus.NOT_FOUND);
        }
        TransaccionesService.deleteById(id);
        return new ResponseEntity<>("Transacciones eliminado correctamente", HttpStatus.OK);
    }
}
