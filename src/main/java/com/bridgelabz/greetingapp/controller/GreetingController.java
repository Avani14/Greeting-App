package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String hello  = "Hello %s!";
    private final AtomicLong id = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting sayHello(@RequestParam(value = "name",defaultValue = "World")String name){
        return new Greeting(id.incrementAndGet(),String.format(hello,name));
    }
    @GetMapping("/greeting/{name}")
    public Greeting sayHelloWithName(@PathVariable String name){
        return new Greeting(id.incrementAndGet(),String.format(hello,name));
    }
    @Autowired
    private IGreetingInterface greeting;

    @GetMapping("/greeting/service")
    public Greeting sayHelloFromServiceLayer(){
        return greeting.message();
    }
}
