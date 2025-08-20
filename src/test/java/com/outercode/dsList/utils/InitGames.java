package com.outercode.dsList.utils;

import com.outercode.dsList.dto.GameMinDTO;
import com.outercode.dsList.entities.Game;

public class InitGames {

    public static final Game GAME = new Game(1L, "Game Title", 2025, 4.5, "genre", "Platform", "https://example.com/image.jpg", "https://example.com/video.mp4", "Game Description");
    public static final GameMinDTO GAME_MIN_DTO = new GameMinDTO(GAME);
    public static final Game INVALID_GAME = new Game(null, "", 0, 0.0, "", "", "", "", "");
}
