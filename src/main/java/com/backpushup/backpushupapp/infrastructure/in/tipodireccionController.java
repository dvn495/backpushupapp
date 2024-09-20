package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.TipodireccionService;
import com.backpushup.backpushupapp.domain.Tipodireccion;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Tipodireccion")
public class TipodireccionController {

    private final TipodireccionService TipodireccionService;

    public TipodireccionController(TipodireccionService TipodireccionService) {
        this.TipodireccionService = TipodireccionService;
    }

    @GetMapping
    public List<Tipodireccion> getAllTipodireccions() {
        return TipodireccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipodireccion> getTipodireccionById(@PathVariable Long id) {
        Optional<Tipodireccion> foundTipodireccion = TipodireccionService.findById(id);
        if (!foundTipodireccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTipodireccion.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tipodireccion> createTipodireccion(@Valid @RequestBody Tipodireccion Tipodireccion) {
        TipodireccionService.save(Tipodireccion);
        return new ResponseEntity<>(Tipodireccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTipodireccion(@PathVariable Long id, @Valid @RequestBody Tipodireccion Tipodireccion) {
        Optional<Tipodireccion> existingTipodireccion = TipodireccionService.findById(id);
        if (!existingTipodireccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tipodireccion.setId(id);
        TipodireccionService.save(Tipodireccion);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Tipodireccion actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipodireccion(@PathVariable Long id) {
        Optional<Tipodireccion> foundTipodireccion = TipodireccionService.findById(id);
        if (!foundTipodireccion.isPresent()){
            return new ResponseEntity<>("Tipodireccion no encontrado", HttpStatus.NOT_FOUND);
        }
        TipodireccionService.deleteById(id);
        return new ResponseEntity<>("Tipodireccion eliminado correctamente", HttpStatus.OK);
    }
}
