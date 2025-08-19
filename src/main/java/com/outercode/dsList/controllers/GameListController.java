package com.outercode.dsList.controllers;

import com.outercode.dsList.dto.GameListDTO;
import com.outercode.dsList.dto.GameMinDTO;
import com.outercode.dsList.services.GameListService;
import com.outercode.dsList.services.GameService;
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
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(gameListService.findAll());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable("listId") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findByList(id));
    }

}
