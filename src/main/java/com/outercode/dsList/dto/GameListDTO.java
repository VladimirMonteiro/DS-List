package com.outercode.dsList.dto;

import com.outercode.dsList.entities.GameList;

public record GameListDTO(Long id, String name) {

    public GameListDTO(GameList entity) {
        this(entity.getId(), entity.getName());
    }
}
