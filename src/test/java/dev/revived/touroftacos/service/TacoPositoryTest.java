package dev.revived.touroftacos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TacoPositoryTest {
    @Autowired
    private TacoPository tacos;

    @BeforeEach
    private void setup() {
        tacos.deleteAll();
    }

    @Test
    void tacopositoryStartsWithLonelyTaco() {
        assertEquals(0, tacos.count());
    }

    @Test
    void tacopositoryAddOne() {
        String name = "nom";
        Taco taco = new Taco();
        taco.setName(name);
        tacos.save(taco);

        assertEquals(1, tacos.count());

        tacos.findAll().forEach(foundTaco -> {
            assertEquals(name, foundTaco.getName());
        });
    }

    @Test
    void tacopositoryAddTwo() {
        List<String> names = newArrayList("omnom", "twosday! get it?!");
        Taco taco = new Taco();
        taco.setName(names.get(0));
        tacos.save(taco);

        Taco tacoTwosday = new Taco();
        tacoTwosday.setName(names.get(1));
        tacos.save(tacoTwosday);


        assertEquals(2, tacos.count());

        List<Taco> foundTacos = newArrayList(tacos.findAll());

        for (int i = 0; i < foundTacos.size(); i++) {
            assertEquals(names.get(i), foundTacos.get(i).getName());
        }
    }

}