package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;
import com.bridgelabz.greetingapp.service.IGreetingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/greeting/service/person/reqBody")
    public Greeting sayHelloFromServiceLayerByPersonWithRequestBody(@RequestBody Person person){
        return new Greeting(id.incrementAndGet(),String.format(hello,person.getFirst_name()+" "+person.getLast_name()));
    }
    @GetMapping("/greeting/service/person/param")
    public Greeting sayHelloFromServiceLayerByPersonWithRequestParam(@RequestParam(value = "first_name" ,defaultValue = "Avani")String first_name,@RequestParam(value = "last_name" ,defaultValue = "Trivedi")String last_name){
        return new Greeting(id.incrementAndGet(),String.format(hello,first_name+" "+last_name));
    }
}
