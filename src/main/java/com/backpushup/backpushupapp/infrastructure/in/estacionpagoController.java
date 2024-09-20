package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.EstacionpagoService;
import com.backpushup.backpushupapp.domain.Estacionpago;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Estacionpago")
public class EstacionpagoController {

    private final EstacionpagoService EstacionpagoService;

    public EstacionpagoController(EstacionpagoService EstacionpagoService) {
        this.EstacionpagoService = EstacionpagoService;
    }

    @GetMapping
    public List<Estacionpago> getAllEstacionpagos() {
        return EstacionpagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estacionpago> getEstacionpagoById(@PathVariable Long id) {
        Optional<Estacionpago> foundEstacionpago = EstacionpagoService.findById(id);
        if (!foundEstacionpago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundEstacionpago.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estacionpago> createEstacionpago(@Valid @RequestBody Estacionpago Estacionpago) {
        EstacionpagoService.save(Estacionpago);
        return new ResponseEntity<>(Estacionpago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateEstacionpago(@PathVariable Long id, @Valid @RequestBody Estacionpago Estacionpago) {
        Optional<Estacionpago> existingEstacionpago = EstacionpagoService.findById(id);
        if (!existingEstacionpago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Estacionpago.setId(id);
        EstacionpagoService.save(Estacionpago);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Estacionpago actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstacionpago(@PathVariable Long id) {
        Optional<Estacionpago> foundEstacionpago = EstacionpagoService.findById(id);
        if (!foundEstacionpago.isPresent()){
            return new ResponseEntity<>("Estacionpago no encontrado", HttpStatus.NOT_FOUND);
        }
        EstacionpagoService.deleteById(id);
        return new ResponseEntity<>("Estacionpago eliminado correctamente", HttpStatus.OK);
    }
}
