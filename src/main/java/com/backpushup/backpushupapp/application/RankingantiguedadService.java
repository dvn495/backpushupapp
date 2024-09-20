package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Rankingantiguedad;
import com.backpushup.backpushupapp.infrastructure.out.RankingantiguedadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RankingantiguedadService {

    private final RankingantiguedadRepository rankingantiguedadRepository;

    public List<Rankingantiguedad> findAll() {
        return rankingantiguedadRepository.findAll();
    }

    public Optional<Rankingantiguedad> findById(Long id) {
        return rankingantiguedadRepository.findById(id);
    }

    public Rankingantiguedad save(Rankingantiguedad entity) {
        return rankingantiguedadRepository.save(entity);
    }

    public void deleteById(Long id) {
        rankingantiguedadRepository.deleteById(id);
    }
}
