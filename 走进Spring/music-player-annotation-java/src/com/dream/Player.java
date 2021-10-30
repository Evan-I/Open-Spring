package com.dream;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component(value = "player")
public class Player {
    private Music music = null;

    public Music getMusic() {
        return this.music;
    }

    @Autowired(required = true)
    public void setMusic(Music music) {
        this.music = music;
    }

    public void play() {
        var musicName = this.music.getMusicName();
        var musicMessage = String.format("开始播放音乐《%s》", musicName);
        System.out.println(musicMessage);
    }

    public void pause() {
        var musicName = this.music.getMusicName();
        var musicMessage = String.format("暂停播放音乐《%s》", musicName);
        System.out.println(musicMessage);
    }
}