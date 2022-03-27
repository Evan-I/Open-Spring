package com.dream;

import org.springframework.context.support.*;

public class Main {
    public static void main(String[] args) {
        var configFile = "resources\\app-config.xml";
        try (var context = new ClassPathXmlApplicationContext(configFile)) {
            var person = context.getBean("person", Person.class);
            person.speak("Hello Spring!");
        }
    }
}