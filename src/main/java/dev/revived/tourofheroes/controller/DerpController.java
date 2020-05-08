package dev.revived.tourofheroes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DerpController {

    public DerpController() {
    }

    @GetMapping(value = "/derp")
    public String gogogogo() {

        return "assasssasss";
    }
}
