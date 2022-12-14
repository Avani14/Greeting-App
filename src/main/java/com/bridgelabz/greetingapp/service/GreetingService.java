package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingInterface{
    private static final String greetings = "Hello World";
    private final AtomicLong id = new AtomicLong();

    @Override
    public Greeting message() {
        return new Greeting(id.incrementAndGet(),String.format(greetings));
    }
    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public String messageFromPersonToDataBase(Person person) {
        greetingRepository.save(person);
        return "Hello "+person.getFirst_name()+" "+person.getLast_name();
    }

    @Override
    public Optional<Person> findId(long id) {
        Optional<Person> person = greetingRepository.findById(id);
        return person;
    }

    @Override
    public List<Person> findAllPerson() {
        List<Person> allEntries = greetingRepository.findAll();
        return allEntries;
    }
    @Override
    public Person edit(long id, Person person) {
        Optional<Person> p1 = this.findId(id);
        p1.get().updateData(person);
        greetingRepository.save(p1.get());
        return p1.get();
    }

    @Override
    public Person delete(long id) {
        Optional<Person> person = this.findId(id);
        greetingRepository.delete(person.get());
        return person.get();
    }


}
