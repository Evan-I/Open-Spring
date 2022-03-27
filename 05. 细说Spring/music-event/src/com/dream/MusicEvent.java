package com.dream;

import org.springframework.context.*;

public class MusicEvent extends ApplicationEvent {
    private String musicName = null;

    public MusicEvent(Object source) {
        super(source);
    }

    public String getMusicName() {
        return this.musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}