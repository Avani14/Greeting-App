package com.bridgelabz.greetingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greetings")
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String first_name;
    private String last_name;
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void updateData(Person person){
        this.first_name = person.getFirst_name();
        this.last_name = person.getLast_name();
    }
}
