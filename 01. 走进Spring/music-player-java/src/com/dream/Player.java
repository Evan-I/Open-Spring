package com.dream;

public abstract class Player {
    protected abstract Music getPlayingMusic();

    public void play() {
        var music = this.getPlayingMusic();
        var musicName = music.getMusicName();
        var musicMessage = String.format("开始播放音乐《%s》", musicName);
        System.out.println(musicMessage);
    }

    public void pause() {
        var music = this.getPlayingMusic();
        var musicName = music.getMusicName();
        var musicMessage = String.format("暂停播放音乐《%s》", musicName);
        System.out.println(musicMessage);
    }
}