package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.TipomovcajaService;
import com.backpushup.backpushupapp.domain.Tipomovcaja;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Tipomovcaja")
public class TipomovcajaController {

    private final TipomovcajaService TipomovcajaService;

    public TipomovcajaController(TipomovcajaService TipomovcajaService) {
        this.TipomovcajaService = TipomovcajaService;
    }

    @GetMapping
    public List<Tipomovcaja> getAllTipomovcajas() {
        return TipomovcajaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipomovcaja> getTipomovcajaById(@PathVariable Long id) {
        Optional<Tipomovcaja> foundTipomovcaja = TipomovcajaService.findById(id);
        if (!foundTipomovcaja.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTipomovcaja.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tipomovcaja> createTipomovcaja(@Valid @RequestBody Tipomovcaja Tipomovcaja) {
        TipomovcajaService.save(Tipomovcaja);
        return new ResponseEntity<>(Tipomovcaja, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTipomovcaja(@PathVariable Long id, @Valid @RequestBody Tipomovcaja Tipomovcaja) {
        Optional<Tipomovcaja> existingTipomovcaja = TipomovcajaService.findById(id);
        if (!existingTipomovcaja.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tipomovcaja.setId(id);
        TipomovcajaService.save(Tipomovcaja);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Tipomovcaja actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipomovcaja(@PathVariable Long id) {
        Optional<Tipomovcaja> foundTipomovcaja = TipomovcajaService.findById(id);
        if (!foundTipomovcaja.isPresent()){
            return new ResponseEntity<>("Tipomovcaja no encontrado", HttpStatus.NOT_FOUND);
        }
        TipomovcajaService.deleteById(id);
        return new ResponseEntity<>("Tipomovcaja eliminado correctamente", HttpStatus.OK);
    }
}
