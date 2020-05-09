package dev.revived.touroftacos.controller;

import dev.revived.touroftacos.service.Taco;
import dev.revived.touroftacos.service.TacoPository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tacos")
public class TacoController {
    private final TacoPository tacoPository;

    @Autowired
    public TacoController(TacoPository tacoPository) {
        this.tacoPository = tacoPository;
    }

    @GetMapping("")
    public Iterable<Taco> tacos() {
        return tacoPository.findAll();
    }

}
