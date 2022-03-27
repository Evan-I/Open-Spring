package com.dream;

import org.springframework.context.annotation.*;

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var player = context.getBean("player", Player.class);
            player.play();
            player.pause();;
        }
    }
}