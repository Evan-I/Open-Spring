package com.dream;

public class Music {
    private String musicName = null;

    public Music(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}