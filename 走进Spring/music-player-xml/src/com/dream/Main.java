package com.dream;

import org.springframework.context.support.*;

public class Main {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("resources\\app-config.xml")) {
            var player = context.getBean("player", Player.class);
            player.play();
            player.pause();
        }
        try (var context = new FileSystemXmlApplicationContext("out\\production\\music-player-xml\\resources\\app-config.xml")) {
            var player = context.getBean("player", Player.class);
            player.play();
            player.pause();
        }
    }
}