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

import com.backpushup.backpushupapp.application.DireccionpersonaService;
import com.backpushup.backpushupapp.domain.Direccionpersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/DireccionPersona")
public class DireccionpersonaController {

    private final DireccionpersonaService DireccionpersonaService;

    public DireccionpersonaController(DireccionpersonaService DireccionpersonaService) {
        this.DireccionpersonaService = DireccionpersonaService;
    }

    @GetMapping
    public List<Direccionpersona> getAllDireccionPersonas() {
        return DireccionpersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccionpersona> getDireccionPersonaById(@PathVariable Long id) {
        Optional<Direccionpersona> foundDireccionPersona = DireccionpersonaService.findById(id);
        if (!foundDireccionPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundDireccionPersona.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Direccionpersona> createDireccionPersona(@Valid @RequestBody Direccionpersona DireccionPersona) {
        DireccionpersonaService.save(DireccionPersona);
        return new ResponseEntity<>(DireccionPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDireccionPersona(@PathVariable Long id, @Valid @RequestBody Direccionpersona DireccionPersona) {
        Optional<Direccionpersona> existingDireccionPersona = DireccionpersonaService.findById(id);
        if (!existingDireccionPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DireccionPersona.setId(id);
        DireccionpersonaService.save(DireccionPersona);
        Map<String, String> response = new HashMap<>();
        response.put("message", "DireccionPersona actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDireccionPersona(@PathVariable Long id) {
        Optional<Direccionpersona> foundDireccionPersona = DireccionpersonaService.findById(id);
        if (!foundDireccionPersona.isPresent()){
            return new ResponseEntity<>("DireccionPersona no encontrado", HttpStatus.NOT_FOUND);
        }
        DireccionpersonaService.deleteById(id);
        return new ResponseEntity<>("DireccionPersona eliminado correctamente", HttpStatus.OK);
    }
}
