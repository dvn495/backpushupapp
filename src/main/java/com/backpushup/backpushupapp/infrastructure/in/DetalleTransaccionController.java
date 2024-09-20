package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.DetalleTransaccionService;
import com.backpushup.backpushupapp.domain.DetalleTransaccion;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/DetalleTransaccion")
public class DetalleTransaccionController {

    private final DetalleTransaccionService Detalle_transaccionService;

    public DetalleTransaccionController(DetalleTransaccionService Detalle_transaccionService) {
        this.Detalle_transaccionService = Detalle_transaccionService;
    }

    @GetMapping
    public List<DetalleTransaccion> getAllDetalleTransaccions() {
        return Detalle_transaccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleTransaccion> getDetalleTransaccionById(@PathVariable Long id) {
        Optional<DetalleTransaccion> foundDetalleTransaccion = Detalle_transaccionService.findById(id);
        if (!foundDetalleTransaccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundDetalleTransaccion.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleTransaccion> createDetalleTransaccion(@Valid @RequestBody DetalleTransaccion DetalleTransaccion) {
        Detalle_transaccionService.save(DetalleTransaccion);
        return new ResponseEntity<>(DetalleTransaccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDetalleTransaccion(@PathVariable Long id, @Valid @RequestBody DetalleTransaccion DetalleTransaccion) {
        Optional<DetalleTransaccion> existingDetalleTransaccion = Detalle_transaccionService.findById(id);
        if (!existingDetalleTransaccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DetalleTransaccion.setId(id);
        Detalle_transaccionService.save(DetalleTransaccion);
        Map<String, String> response = new HashMap<>();
        response.put("message", "DetalleTransaccion actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDetalleTransaccion(@PathVariable Long id) {
        Optional<DetalleTransaccion> foundDetalleTransaccion = Detalle_transaccionService.findById(id);
        if (!foundDetalleTransaccion.isPresent()){
            return new ResponseEntity<>("DetalleTransaccion no encontrado", HttpStatus.NOT_FOUND);
        }
        Detalle_transaccionService.deleteById(id);
        return new ResponseEntity<>("DetalleTransaccion eliminado correctamente", HttpStatus.OK);
    }
}
