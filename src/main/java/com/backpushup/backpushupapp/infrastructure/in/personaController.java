package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.PersonaService;
import com.backpushup.backpushupapp.domain.Persona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Persona")
public class PersonaController {

    private final PersonaService PersonaService;

    public PersonaController(PersonaService PersonaService) {
        this.PersonaService = PersonaService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return PersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> foundPersona = PersonaService.findById(id);
        if (!foundPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPersona.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@Valid @RequestBody Persona Persona) {
        PersonaService.save(Persona);
        return new ResponseEntity<>(Persona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updatePersona(@PathVariable Long id, @Valid @RequestBody Persona Persona) {
        Optional<Persona> existingPersona = PersonaService.findById(id);
        if (!existingPersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Persona.setId(id);
        PersonaService.save(Persona);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Persona actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        Optional<Persona> foundPersona = PersonaService.findById(id);
        if (!foundPersona.isPresent()){
            return new ResponseEntity<>("Persona no encontrado", HttpStatus.NOT_FOUND);
        }
        PersonaService.deleteById(id);
        return new ResponseEntity<>("Persona eliminado correctamente", HttpStatus.OK);
    }
}
