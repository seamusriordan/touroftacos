package dev.revived.touroftacos.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TacoPository {

    private final ArrayList<Taco> tacos;

    public TacoPository() {
        tacos = new ArrayList<>(0);
        tacos.add(new Taco("The lonely taco"));
    }

    public int size() {
        return tacos.size();
    }

    public void add(Taco taco) {
        tacos.add(taco);
    }

    public List<Taco> getTacos() {
        return tacos;
    }
}
