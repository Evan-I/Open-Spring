package com.dream;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    private static int index = 0;

    @Bean(name = "music")
    @Scope(value = "prototype")
    public Music produceMusic() {
        index++;
        return new Music("Dream " + index);
    }

    @Bean(name = "player")
    public Player producePlayer() {
        return new Player() {
            @Override
            protected Music getPlayingMusic(){
                return produceMusic();
            }
        };
    }
}