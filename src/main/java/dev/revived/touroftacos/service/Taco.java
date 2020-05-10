package dev.revived.touroftacos.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Taco {
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    public Taco() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
