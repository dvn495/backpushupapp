package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.ContactopersonaService;
import com.backpushup.backpushupapp.domain.Contactopersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Contactopersona")
public class ContactopersonaController {

    private final ContactopersonaService ContactopersonaService;

    public ContactopersonaController(ContactopersonaService ContactopersonaService) {
        this.ContactopersonaService = ContactopersonaService;
    }

    @GetMapping
    public List<Contactopersona> getAllContactopersonas() {
        return ContactopersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contactopersona> getContactopersonaById(@PathVariable Long id) {
        Optional<Contactopersona> foundContactopersona = ContactopersonaService.findById(id);
        if (!foundContactopersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundContactopersona.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contactopersona> createContactopersona(@Valid @RequestBody Contactopersona Contactopersona) {
        ContactopersonaService.save(Contactopersona);
        return new ResponseEntity<>(Contactopersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateContactopersona(@PathVariable Long id, @Valid @RequestBody Contactopersona Contactopersona) {
        Optional<Contactopersona> existingContactopersona = ContactopersonaService.findById(id);
        if (!existingContactopersona.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Contactopersona.setId(id);
        ContactopersonaService.save(Contactopersona);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Contactopersona actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContactopersona(@PathVariable Long id) {
        Optional<Contactopersona> foundContactopersona = ContactopersonaService.findById(id);
        if (!foundContactopersona.isPresent()){
            return new ResponseEntity<>("Contactopersona no encontrado", HttpStatus.NOT_FOUND);
        }
        ContactopersonaService.deleteById(id);
        return new ResponseEntity<>("Contactopersona eliminado correctamente", HttpStatus.OK);
    }
}
