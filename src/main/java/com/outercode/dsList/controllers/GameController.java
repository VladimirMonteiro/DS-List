package com.outercode.dsList.controllers;

import com.outercode.dsList.dto.GameDTO;
import com.outercode.dsList.dto.GameMinDTO;
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
@RequestMapping(value = "/games", produces = "application/json")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findById(id));
    }
}
