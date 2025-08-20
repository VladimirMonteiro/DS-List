package com.outercode.dsList.controllers;

import com.outercode.dsList.dto.GameDTO;
import com.outercode.dsList.dto.GameMinDTO;
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
@RequestMapping(value = "/games", produces = "application/json")
@Tag(name = "Games", description = "Controller for managing games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    @Operation(summary = "Find all games.", description = "This feature returns all games available in the system.")
    @ApiResponse(responseCode = "200", description = "Returned list of games.")
    public ResponseEntity<List<GameMinDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find game by ID.", description = "This feature returns a game by its ID.")
    @ApiResponse(responseCode = "200", description = "Returned game details by ID.")
    public ResponseEntity<GameDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findById(id));
    }
}
