package com.outercode.dsList.dto;

import com.outercode.dsList.entities.Game;

public record GameDTO(String title,
                      Integer year,
                      Double score,
                      String genre,
                      String platforms,
                      String imgUrl,
                      String shortDescription,
                      String longDescription){

    public GameDTO(Game entity) {
        this(entity.getTitle(), entity.getYear(), entity.getScore(), entity.getGenre(), entity.getPlatforms(),
             entity.getImgUrl(), entity.getShortDescription(), entity.getLongDescription());
    }

}
