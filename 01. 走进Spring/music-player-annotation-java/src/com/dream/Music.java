package com.dream;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component(value = "music")
public class Music {
    private String musicName = null;

    public String getMusicName() {
        return this.musicName;
    }

    @Value(value="执着")
    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}