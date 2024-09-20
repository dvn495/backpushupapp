package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.CategoriasService;
import com.backpushup.backpushupapp.domain.Categorias;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Categorias")
public class CategoriasController {

    private final CategoriasService CategoriasService;

    public CategoriasController(CategoriasService CategoriasService) {
        this.CategoriasService = CategoriasService;
    }

    @GetMapping
    public List<Categorias> getAllCategoriass() {
        return CategoriasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getCategoriasById(@PathVariable Long id) {
        Optional<Categorias> foundCategorias = CategoriasService.findById(id);
        if (!foundCategorias.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundCategorias.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categorias> createCategorias(@Valid @RequestBody Categorias Categorias) {
        CategoriasService.save(Categorias);
        return new ResponseEntity<>(Categorias, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateCategorias(@PathVariable Long id, @Valid @RequestBody Categorias Categorias) {
        Optional<Categorias> existingCategorias = CategoriasService.findById(id);
        if (!existingCategorias.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Categorias.setId(id);
        CategoriasService.save(Categorias);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Categorias actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategorias(@PathVariable Long id) {
        Optional<Categorias> foundCategorias = CategoriasService.findById(id);
        if (!foundCategorias.isPresent()){
            return new ResponseEntity<>("Categorias no encontrado", HttpStatus.NOT_FOUND);
        }
        CategoriasService.deleteById(id);
        return new ResponseEntity<>("Categorias eliminado correctamente", HttpStatus.OK);
    }
}
