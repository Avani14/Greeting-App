package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IGreetingInterface {
    Greeting message();
    String messageFromPersonToDataBase(Person person);
    Optional<Person> findId(long id);
    List<Person> findAllPerson();
    Person edit(long id, Person person);
    Person delete(long id);
}
