package com.outercode.dsList.controllers;

import com.outercode.dsList.dto.GameListDTO;
import com.outercode.dsList.dto.GameMinDTO;
import com.outercode.dsList.services.GameListService;
import com.outercode.dsList.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/game-lists", produces = "application/json")
@Tag(name = "Games list", description = "Controller from manage of games lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    @Operation(summary = "Find all list of games.", description = "This feature return all game lists available in the system.")
    @ApiResponse(responseCode = "200", description = "Returned list of games.")
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(gameListService.findAll());
    }

    @GetMapping("/{listId}/games")
    @Operation(summary = "Find all games of one list using id.", description = "This feature return all games of an list available in the system.")
    @ApiResponse(responseCode = "200", description = "Returned games of one list using id.")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable("listId") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findByList(id));
    }
}
