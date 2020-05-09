package dev.revived.touroftacos.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TacoPositoryTest {
    @Test
    void tacopositoryStartsEmpty() {
        var tacos = new TacoPository();

        assertEquals(0, tacos.size());
    }

    @Test
    void tacopositoryAddOne() {
        var tacos = new TacoPository();

        String name = "nom";
        tacos.add(new Taco(name));

        assertEquals(1, tacos.size());
        assertEquals(name, tacos.getTacos().get(0).getName());
    }

    @Test
    void tacopositoryAddTwo() {
        var tacos = new TacoPository();

        String name = "omnom";
        tacos.add(new Taco(name));
        tacos.add(new Taco(name));

        assertEquals(2, tacos.size());
        assertEquals(name, tacos.getTacos().get(1).getName());
    }

}