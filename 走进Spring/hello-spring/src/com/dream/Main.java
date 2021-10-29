package com.dream;

import org.springframework.context.support.*;

public class Main {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("resources\\app-config.xml")) {
            var person = context.getBean("person", Person.class);
            person.speak("Hello Spring!");
        }
    }
}