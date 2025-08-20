package com.outercode.dsList.services;

import com.outercode.dsList.dto.GameDTO;
import com.outercode.dsList.dto.GameMinDTO;
import com.outercode.dsList.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

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

    @Test
    void findGameById_WithValidId_ReturnsGame() {
        when(gameRepository.findById(anyLong())).thenReturn(Optional.of(GAME));

        var result = gameService.findById(GAME.getId());

        assertNotNull(result);
        assertEquals(result.id(), GAME.getId());
        assertEquals(result.title(), GAME.getTitle());
        assertEquals(result.year(), GAME.getYear());
        assertEquals(result.score(), GAME.getScore());
        assertEquals(result.genre(), GAME.getGenre());
        assertEquals(result.platforms(), GAME.getPlatforms());
        assertEquals(result.imgUrl(), GAME.getImgUrl());
        assertEquals(result.shortDescription(), GAME.getShortDescription());
        assertEquals(result.longDescription(), GAME.getLongDescription());
        assertEquals(GameDTO.class, result.getClass());
        verify(gameRepository, times(1)).findById(anyLong());
    }

    @Test
    void findGameById_WithInvalidId_ThrowsException() {
        when(gameRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            gameService.findById(999L);
        });

        assertNotNull(exception);

        String expectedMessage = "Game not found with id: 999";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(gameRepository, times(1)).findById(anyLong());
    }
}