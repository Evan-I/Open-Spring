package com.dream;

import java.util.*;
import org.springframework.context.*;

public class MusicService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher = null;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void play(String musicName) {
        var hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hourOfDay == 23) {
            var musicEvent = new MusicEvent();
            musicEvent.setMusicName(musicName);
            publisher.publishEvent(musicEvent);
        }
    }
}