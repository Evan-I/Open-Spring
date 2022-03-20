package com.dream;

import org.springframework.context.*;

public class MusicListener implements ApplicationListener<MusicEvent> {
    @Override
    public void onApplicationEvent(MusicEvent musicEvent) {
        var musicName = musicEvent.getMusicName();
        var playingMessage = String.format("正在为您播放音乐《%s》", musicName);
        System.out.println(playingMessage);
    }
}