package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.EmpleadosService;
import com.backpushup.backpushupapp.domain.Empleados;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Empleados")
public class EmpleadosController {

    private final EmpleadosService EmpleadosService;

    public EmpleadosController(EmpleadosService EmpleadosService) {
        this.EmpleadosService = EmpleadosService;
    }

    @GetMapping
    public List<Empleados> getAllEmpleadoss() {
        return EmpleadosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleados> getEmpleadosById(@PathVariable Long id) {
        Optional<Empleados> foundEmpleados = EmpleadosService.findById(id);
        if (!foundEmpleados.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundEmpleados.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empleados> createEmpleados(@Valid @RequestBody Empleados Empleados) {
        EmpleadosService.save(Empleados);
        return new ResponseEntity<>(Empleados, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateEmpleados(@PathVariable Long id, @Valid @RequestBody Empleados Empleados) {
        Optional<Empleados> existingEmpleados = EmpleadosService.findById(id);
        if (!existingEmpleados.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Empleados.setId(id);
        EmpleadosService.save(Empleados);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Empleados actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpleados(@PathVariable Long id) {
        Optional<Empleados> foundEmpleados = EmpleadosService.findById(id);
        if (!foundEmpleados.isPresent()){
            return new ResponseEntity<>("Empleados no encontrado", HttpStatus.NOT_FOUND);
        }
        EmpleadosService.deleteById(id);
        return new ResponseEntity<>("Empleados eliminado correctamente", HttpStatus.OK);
    }
}
