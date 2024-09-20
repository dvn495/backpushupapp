package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.AntiguedadesService;
import com.backpushup.backpushupapp.domain.Antiguedades;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Antiguedades")
public class AntiguedadesController {

    private final AntiguedadesService AntiguedadesService;

    public AntiguedadesController(AntiguedadesService AntiguedadesService) {
        this.AntiguedadesService = AntiguedadesService;
    }

    @GetMapping
    public List<Antiguedades> getAllAntiguedadess() {
        return AntiguedadesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Antiguedades> getAntiguedadesById(@PathVariable Long id) {
        Optional<Antiguedades> foundAntiguedades = AntiguedadesService.findById(id);
        if (!foundAntiguedades.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundAntiguedades.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Antiguedades> createAntiguedades(@Valid @RequestBody Antiguedades Antiguedades) {
        AntiguedadesService.save(Antiguedades);
        return new ResponseEntity<>(Antiguedades, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateAntiguedades(@PathVariable Long id, @Valid @RequestBody Antiguedades Antiguedades) {
        Optional<Antiguedades> existingAntiguedades = AntiguedadesService.findById(id);
        if (!existingAntiguedades.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Antiguedades.setId(id);
        AntiguedadesService.save(Antiguedades);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Antiguedades actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAntiguedades(@PathVariable Long id) {
        Optional<Antiguedades> foundAntiguedades = AntiguedadesService.findById(id);
        if (!foundAntiguedades.isPresent()){
            return new ResponseEntity<>("Antiguedades no encontrado", HttpStatus.NOT_FOUND);
        }
        AntiguedadesService.deleteById(id);
        return new ResponseEntity<>("Antiguedades eliminado correctamente", HttpStatus.OK);
    }
}
