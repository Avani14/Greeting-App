package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingInterface{
    private static final String greetings = "Hello World";
    private final AtomicLong id = new AtomicLong();

    @Override
    public Greeting message() {
        return new Greeting(id.incrementAndGet(),String.format(greetings));
    }

}
