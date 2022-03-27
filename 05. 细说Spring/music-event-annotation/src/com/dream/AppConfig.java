package com.dream;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean("musicService")
    public MusicService produceMusicService() {
        return new MusicService();
    }

    @Bean("musicListener")
    public MusicListener produceMusicListener() {
        return new MusicListener();
    }
}