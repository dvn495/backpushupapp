package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.CiudadesService;
import com.backpushup.backpushupapp.domain.Ciudades;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Ciudades")
public class CiudadesController {

    private final CiudadesService CiudadesService;

    public CiudadesController(CiudadesService CiudadesService) {
        this.CiudadesService = CiudadesService;
    }

    @GetMapping
    public List<Ciudades> getAllCiudadess() {
        return CiudadesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudades> getCiudadesById(@PathVariable Long id) {
        Optional<Ciudades> foundCiudades = CiudadesService.findById(id);
        if (!foundCiudades.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundCiudades.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ciudades> createCiudades(@Valid @RequestBody Ciudades Ciudades) {
        CiudadesService.save(Ciudades);
        return new ResponseEntity<>(Ciudades, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateCiudades(@PathVariable Long id, @Valid @RequestBody Ciudades Ciudades) {
        Optional<Ciudades> existingCiudades = CiudadesService.findById(id);
        if (!existingCiudades.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Ciudades.setId(id);
        CiudadesService.save(Ciudades);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Ciudades actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCiudades(@PathVariable Long id) {
        Optional<Ciudades> foundCiudades = CiudadesService.findById(id);
        if (!foundCiudades.isPresent()){
            return new ResponseEntity<>("Ciudades no encontrado", HttpStatus.NOT_FOUND);
        }
        CiudadesService.deleteById(id);
        return new ResponseEntity<>("Ciudades eliminado correctamente", HttpStatus.OK);
    }
}
