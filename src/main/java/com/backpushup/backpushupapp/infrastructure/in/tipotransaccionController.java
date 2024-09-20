package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.TipotransaccionService;
import com.backpushup.backpushupapp.domain.Tipotransaccion;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Tipotransaccion")
public class TipotransaccionController {

    private final TipotransaccionService TipotransaccionService;

    public TipotransaccionController(TipotransaccionService TipotransaccionService) {
        this.TipotransaccionService = TipotransaccionService;
    }

    @GetMapping
    public List<Tipotransaccion> getAllTipotransaccions() {
        return TipotransaccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipotransaccion> getTipotransaccionById(@PathVariable Long id) {
        Optional<Tipotransaccion> foundTipotransaccion = TipotransaccionService.findById(id);
        if (!foundTipotransaccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTipotransaccion.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tipotransaccion> createTipotransaccion(@Valid @RequestBody Tipotransaccion Tipotransaccion) {
        TipotransaccionService.save(Tipotransaccion);
        return new ResponseEntity<>(Tipotransaccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTipotransaccion(@PathVariable Long id, @Valid @RequestBody Tipotransaccion Tipotransaccion) {
        Optional<Tipotransaccion> existingTipotransaccion = TipotransaccionService.findById(id);
        if (!existingTipotransaccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tipotransaccion.setId(id);
        TipotransaccionService.save(Tipotransaccion);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Tipotransaccion actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipotransaccion(@PathVariable Long id) {
        Optional<Tipotransaccion> foundTipotransaccion = TipotransaccionService.findById(id);
        if (!foundTipotransaccion.isPresent()){
            return new ResponseEntity<>("Tipotransaccion no encontrado", HttpStatus.NOT_FOUND);
        }
        TipotransaccionService.deleteById(id);
        return new ResponseEntity<>("Tipotransaccion eliminado correctamente", HttpStatus.OK);
    }
}
