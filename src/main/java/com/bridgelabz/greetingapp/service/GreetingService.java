package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

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

}
