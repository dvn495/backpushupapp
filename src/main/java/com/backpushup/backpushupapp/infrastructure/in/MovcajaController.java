package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.MovcajaService;
import com.backpushup.backpushupapp.domain.Movcaja;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Movcaja")
public class MovcajaController {

    private final MovcajaService MovcajaService;

    public MovcajaController(MovcajaService MovcajaService) {
        this.MovcajaService = MovcajaService;
    }

    @GetMapping
    public List<Movcaja> getAllMovcajas() {
        return MovcajaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movcaja> getMovcajaById(@PathVariable Long id) {
        Optional<Movcaja> foundMovcaja = MovcajaService.findById(id);
        if (!foundMovcaja.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundMovcaja.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movcaja> createMovcaja(@Valid @RequestBody Movcaja Movcaja) {
        MovcajaService.save(Movcaja);
        return new ResponseEntity<>(Movcaja, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateMovcaja(@PathVariable Long id, @Valid @RequestBody Movcaja Movcaja) {
        Optional<Movcaja> existingMovcaja = MovcajaService.findById(id);
        if (!existingMovcaja.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Movcaja.setId(id);
        MovcajaService.save(Movcaja);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Movcaja actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovcaja(@PathVariable Long id) {
        Optional<Movcaja> foundMovcaja = MovcajaService.findById(id);
        if (!foundMovcaja.isPresent()){
            return new ResponseEntity<>("Movcaja no encontrado", HttpStatus.NOT_FOUND);
        }
        MovcajaService.deleteById(id);
        return new ResponseEntity<>("Movcaja eliminado correctamente", HttpStatus.OK);
    }
}
