package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.TransaccionmediopagoService;
import com.backpushup.backpushupapp.domain.Transaccionmediopago;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Transaccionmediopago")
public class TransaccionmediopagoController {

    private final TransaccionmediopagoService TransaccionmediopagoService;

    public TransaccionmediopagoController(TransaccionmediopagoService TransaccionmediopagoService) {
        this.TransaccionmediopagoService = TransaccionmediopagoService;
    }

    @GetMapping
    public List<Transaccionmediopago> getAllTransaccionmediopagos() {
        return TransaccionmediopagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccionmediopago> getTransaccionmediopagoById(@PathVariable Long id) {
        Optional<Transaccionmediopago> foundTransaccionmediopago = TransaccionmediopagoService.findById(id);
        if (!foundTransaccionmediopago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTransaccionmediopago.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaccionmediopago> createTransaccionmediopago(@Valid @RequestBody Transaccionmediopago Transaccionmediopago) {
        TransaccionmediopagoService.save(Transaccionmediopago);
        return new ResponseEntity<>(Transaccionmediopago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTransaccionmediopago(@PathVariable Long id, @Valid @RequestBody Transaccionmediopago Transaccionmediopago) {
        Optional<Transaccionmediopago> existingTransaccionmediopago = TransaccionmediopagoService.findById(id);
        if (!existingTransaccionmediopago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Transaccionmediopago.setId(id);
        TransaccionmediopagoService.save(Transaccionmediopago);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Transaccionmediopago actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaccionmediopago(@PathVariable Long id) {
        Optional<Transaccionmediopago> foundTransaccionmediopago = TransaccionmediopagoService.findById(id);
        if (!foundTransaccionmediopago.isPresent()){
            return new ResponseEntity<>("Transaccionmediopago no encontrado", HttpStatus.NOT_FOUND);
        }
        TransaccionmediopagoService.deleteById(id);
        return new ResponseEntity<>("Transaccionmediopago eliminado correctamente", HttpStatus.OK);
    }
}
