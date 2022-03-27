package com.dream;

public abstract class MusicManager {
    public Music process(String musicName) {
        return this.createMusic();
    }

    protected abstract Music createMusic();
}