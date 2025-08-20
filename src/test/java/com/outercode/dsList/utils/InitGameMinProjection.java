package com.outercode.dsList.utils;

import com.outercode.dsList.entities.Game;
import com.outercode.dsList.projections.GameMinProjection;

public class InitGameMinProjection implements GameMinProjection {
    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public String getTitle() {
        return "Game Title";
    }

    @Override
    public Integer getGameYear() {
        return 2025;
    }

    @Override
    public String getImgUrl() {
        return "https://example.com/image.jpg";
    }

    @Override
    public String getShortDescription() {
        return "https://example.com/video.mp4";
    }

    @Override
    public Integer getPosition() {
        return 0;
    }
}
