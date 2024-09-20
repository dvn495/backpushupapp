package com.backpushup.backpushupapp.infrastructure.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpushup.backpushupapp.application.RankingantiguedadService;
import com.backpushup.backpushupapp.domain.Rankingantiguedad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Rankingantiguedad")
public class RankingantiguedadController {

    private final RankingantiguedadService RankingantiguedadService;

    public RankingantiguedadController(RankingantiguedadService RankingantiguedadService) {
        this.RankingantiguedadService = RankingantiguedadService;
    }

    @GetMapping
    public List<Rankingantiguedad> getAllRankingantiguedads() {
        return RankingantiguedadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rankingantiguedad> getRankingantiguedadById(@PathVariable Long id) {
        Optional<Rankingantiguedad> foundRankingantiguedad = RankingantiguedadService.findById(id);
        if (!foundRankingantiguedad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundRankingantiguedad.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rankingantiguedad> createRankingantiguedad(@Valid @RequestBody Rankingantiguedad Rankingantiguedad) {
        RankingantiguedadService.save(Rankingantiguedad);
        return new ResponseEntity<>(Rankingantiguedad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateRankingantiguedad(@PathVariable Long id, @Valid @RequestBody Rankingantiguedad Rankingantiguedad) {
        Optional<Rankingantiguedad> existingRankingantiguedad = RankingantiguedadService.findById(id);
        if (!existingRankingantiguedad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Rankingantiguedad.setId(id);
        RankingantiguedadService.save(Rankingantiguedad);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Rankingantiguedad actualizado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRankingantiguedad(@PathVariable Long id) {
        Optional<Rankingantiguedad> foundRankingantiguedad = RankingantiguedadService.findById(id);
        if (!foundRankingantiguedad.isPresent()){
            return new ResponseEntity<>("Rankingantiguedad no encontrado", HttpStatus.NOT_FOUND);
        }
        RankingantiguedadService.deleteById(id);
        return new ResponseEntity<>("Rankingantiguedad eliminado correctamente", HttpStatus.OK);
    }
}
