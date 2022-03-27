package com.dream;

import org.springframework.context.event.*;
import org.springframework.scheduling.annotation.*;

public class MusicListener {
    @Async
    @EventListener
    public void onMusicEvent(MusicEvent musicEvent) {
        var musicName = musicEvent.getMusicName();
        var playingMessage = String.format("正在为您播放音乐《%s》", musicName);
        System.out.println(playingMessage);
    }
}