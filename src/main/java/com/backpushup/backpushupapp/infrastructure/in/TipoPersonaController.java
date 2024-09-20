package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backpushup.backpushupapp.application.TipoPersonaService;
import com.backpushup.backpushupapp.domain.TipoPersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipo_persona")
public class TipoPersonaController {

    private final TipoPersonaService TipoPersonaService;

    public TipoPersonaController(TipoPersonaService TipoPersonaService) {
        this.TipoPersonaService = TipoPersonaService;
    }

    @GetMapping
    public List<TipoPersona> getAllTipoPersonas() {
        return TipoPersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> getTipoPersonaById(@PathVariable Long id) {
        Optional<TipoPersona> foundTipoPersona = TipoPersonaService.findById(id);
        if (!foundTipoPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTipoPersona.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoPersona> createTipoPersona(@Valid @RequestBody TipoPersona TipoPersona) {
        TipoPersonaService.save(TipoPersona);
        return new ResponseEntity<>(TipoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTipoPersona(@PathVariable Long id, @Valid @RequestBody TipoPersona TipoPersona) {
        Optional<TipoPersona> existingTipoPersona = TipoPersonaService.findById(id);
        if (!existingTipoPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        TipoPersona.setId(id);
        TipoPersonaService.save(TipoPersona);
        Map<String, String> response = new HashMap<>();
        response.put("message", "TipoPersona actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipoPersona(@PathVariable Long id) {
        Optional<TipoPersona> foundTipoPersona = TipoPersonaService.findById(id);
        if (!foundTipoPersona.isPresent()){
            return new ResponseEntity<>("TipoPersona no encontrado", HttpStatus.NOT_FOUND);
        }
        TipoPersonaService.deleteById(id);
        return new ResponseEntity<>("TipoPersona eliminado correctamente", HttpStatus.OK);
    }
}
