package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.SucursalService;
import com.backpushup.backpushupapp.domain.Sucursal;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Sucursal")
public class SucursalController {

    private final SucursalService SucursalService;

    public SucursalController(SucursalService SucursalService) {
        this.SucursalService = SucursalService;
    }

    @GetMapping
    public List<Sucursal> getAllSucursals() {
        return SucursalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable Long id) {
        Optional<Sucursal> foundSucursal = SucursalService.findById(id);
        if (!foundSucursal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundSucursal.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sucursal> createSucursal(@Valid @RequestBody Sucursal Sucursal) {
        SucursalService.save(Sucursal);
        return new ResponseEntity<>(Sucursal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateSucursal(@PathVariable Long id, @Valid @RequestBody Sucursal Sucursal) {
        Optional<Sucursal> existingSucursal = SucursalService.findById(id);
        if (!existingSucursal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Sucursal.setId(id);
        SucursalService.save(Sucursal);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Sucursal actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSucursal(@PathVariable Long id) {
        Optional<Sucursal> foundSucursal = SucursalService.findById(id);
        if (!foundSucursal.isPresent()){
            return new ResponseEntity<>("Sucursal no encontrado", HttpStatus.NOT_FOUND);
        }
        SucursalService.deleteById(id);
        return new ResponseEntity<>("Sucursal eliminado correctamente", HttpStatus.OK);
    }
}
