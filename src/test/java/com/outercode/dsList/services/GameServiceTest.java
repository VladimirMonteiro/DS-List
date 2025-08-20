package com.outercode.dsList.services;

import com.outercode.dsList.dto.GameMinDTO;
import com.outercode.dsList.entities.Game;
import com.outercode.dsList.repositories.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.outercode.dsList.utils.InitGames.GAME;
import static com.outercode.dsList.utils.InitGames.GAME_MIN_DTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @Test
    void ListGames_ReturnAllGames() {
        when(gameRepository.findAll()).thenReturn(List.of(GAME));

        List<GameMinDTO> result = gameService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(GAME_MIN_DTO.id(), result.getFirst().id());
        assertEquals(GAME_MIN_DTO.title(), result.getFirst().title());
        assertEquals(GAME_MIN_DTO.year(), result.getFirst().year());
        assertEquals(GAME_MIN_DTO.imgUrl(), result.getFirst().imgUrl());
        assertEquals(GAME_MIN_DTO.shortDescription(), result.getFirst().shortDescription());
        verify(gameRepository, times(1)).findAll();
    }
}