package com.dream;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean(name = "music")
    public Music produceMusic() {
        var music = new Music();
        music.setMusicName("执着");
        return music;
    }

    @Bean(name = "player")
    public Player producePlayer() {
        var music = this.produceMusic();
        var player = new Player();
        player.setMusic(music);
        return player;
    }

    @Bean(name="player_2")
    public Player producePlayer_2() {
        Music music = this.produceMusic();
        Player player = new Player();
        player.setMusic(music);
        return player;
    }
}