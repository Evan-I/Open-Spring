package com.dream;

public class Main {
    public static void main(String[] args) {
        var newPerson = new Person();
        newPerson.setName("曹操");
        newPerson.setGender("帅哥");

        var daoPerson = new DaoPerson();
        daoPerson.addPerson(newPerson);

        var personList = daoPerson.queryPersonByName("曹操");
        for(var person: personList) {
            System.out.printf("您好！我是%s，是个%s！%n", person.getName(), person.getGender());
        }
    }
}