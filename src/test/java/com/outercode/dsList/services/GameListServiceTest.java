package com.outercode.dsList.services;

import com.outercode.dsList.dto.GameListDTO;
import com.outercode.dsList.entities.GameList;
import com.outercode.dsList.repositories.GameListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameListServiceTest {

    @InjectMocks
    private GameListService gameListService;

    @Mock
    private GameListRepository gameListRepository;

    @Test
    void findAll_ReturnsAnListOfGamesList() {
        var gameList = new GameList(1L, "Name game list");
        var gameListDTO = new GameListDTO(gameList);
        when(gameListRepository.findAll()).thenReturn(List.of(gameList));

        List<GameListDTO> result = gameListService.findAll();

        assertNotNull(result);
        assertEquals(GameListDTO.class, result.getFirst().getClass());
        assertEquals(1, result.size());
        assertEquals(gameListDTO, result.getFirst());
        verify(gameListRepository, times(1)).findAll();
    }
}

