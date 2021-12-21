package com.dream;

import org.springframework.context.support.*;

public class Main {
    public static void main(String[] args) {
        var configFile = "resources\\app-config.xml";
        try (var context = new ClassPathXmlApplicationContext(configFile)) {
            var player = context.getBean("player", Player.class);
            player.play();
            player.pause();
        }

        configFile = "out\\production\\music-player-xml\\resources\\app-config.xml";
        try (var context = new FileSystemXmlApplicationContext(configFile)) {
            var player = context.getBean("player", Player.class);
            player.play();
            player.pause();
        }
    }
}