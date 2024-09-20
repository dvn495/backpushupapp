package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.PersonatipopersonaService;
import com.backpushup.backpushupapp.domain.Personatipopersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Personatipopersona")
public class PersonatipopersonaController {

    private final PersonatipopersonaService PersonatipopersonaService;

    public PersonatipopersonaController(PersonatipopersonaService PersonatipopersonaService) {
        this.PersonatipopersonaService = PersonatipopersonaService;
    }

    @GetMapping
    public List<Personatipopersona> getAllPersonatipopersonas() {
        return PersonatipopersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personatipopersona> getPersonatipopersonaById(@PathVariable Long id) {
        Optional<Personatipopersona> foundPersonatipopersona = PersonatipopersonaService.findById(id);
        if (!foundPersonatipopersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPersonatipopersona.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Personatipopersona> createPersonatipopersona(@Valid @RequestBody Personatipopersona Personatipopersona) {
        PersonatipopersonaService.save(Personatipopersona);
        return new ResponseEntity<>(Personatipopersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updatePersonatipopersona(@PathVariable Long id, @Valid @RequestBody Personatipopersona Personatipopersona) {
        Optional<Personatipopersona> existingPersonatipopersona = PersonatipopersonaService.findById(id);
        if (!existingPersonatipopersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Personatipopersona.setId(id);
        PersonatipopersonaService.save(Personatipopersona);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Personatipopersona actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonatipopersona(@PathVariable Long id) {
        Optional<Personatipopersona> foundPersonatipopersona = PersonatipopersonaService.findById(id);
        if (!foundPersonatipopersona.isPresent()){
            return new ResponseEntity<>("Personatipopersona no encontrado", HttpStatus.NOT_FOUND);
        }
        PersonatipopersonaService.deleteById(id);
        return new ResponseEntity<>("Personatipopersona eliminado correctamente", HttpStatus.OK);
    }
}
