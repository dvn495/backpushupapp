package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.MediopagoService;
import com.backpushup.backpushupapp.domain.Mediopago;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Mediopago")
public class MediopagoController {

    private final MediopagoService MediopagoService;

    public MediopagoController(MediopagoService MediopagoService) {
        this.MediopagoService = MediopagoService;
    }

    @GetMapping
    public List<Mediopago> getAllMediopagos() {
        return MediopagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mediopago> getMediopagoById(@PathVariable Long id) {
        Optional<Mediopago> foundMediopago = MediopagoService.findById(id);
        if (!foundMediopago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundMediopago.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mediopago> createMediopago(@Valid @RequestBody Mediopago Mediopago) {
        MediopagoService.save(Mediopago);
        return new ResponseEntity<>(Mediopago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateMediopago(@PathVariable Long id, @Valid @RequestBody Mediopago Mediopago) {
        Optional<Mediopago> existingMediopago = MediopagoService.findById(id);
        if (!existingMediopago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Mediopago.setId(id);
        MediopagoService.save(Mediopago);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Mediopago actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMediopago(@PathVariable Long id) {
        Optional<Mediopago> foundMediopago = MediopagoService.findById(id);
        if (!foundMediopago.isPresent()){
            return new ResponseEntity<>("Mediopago no encontrado", HttpStatus.NOT_FOUND);
        }
        MediopagoService.deleteById(id);
        return new ResponseEntity<>("Mediopago eliminado correctamente", HttpStatus.OK);
    }
}
