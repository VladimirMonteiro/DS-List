package com.outercode.dsList.services;

import com.outercode.dsList.dto.GameDTO;
import com.outercode.dsList.dto.GameMinDTO;
import com.outercode.dsList.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream()
                .map(GameMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return gameRepository.findById(id)
                .map(GameDTO::new)
                .orElseThrow(() -> new RuntimeException("Game not found with id: " + id));
    }
}
