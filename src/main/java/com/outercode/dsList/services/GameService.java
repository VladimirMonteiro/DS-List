package com.outercode.dsList.services;

import com.outercode.dsList.dto.GameMinDTO;
import com.outercode.dsList.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
