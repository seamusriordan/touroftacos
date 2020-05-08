package dev.revived.tourofheroes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/derp")
public class DerpController {
    class Garbage {
        public Garbage() {
        }

        private String thing = "stuff";

        public Integer r = -47;

        public String getThing() {
            return thing;
        }

        public Float getF() {
            return 60.f;
        }

        public Float getF(double f) {
            return (float) f;
        }
    }

    @Autowired
    public DerpController() {
    }

    Logger logger = LoggerFactory.getLogger(DerpController.class);


    @GetMapping("")
    public String gogogogo() {

        return "assasssasss";
    }

    @GetMapping("/json")
    public String json() {

        String v = "";
        try {
            v = new ObjectMapper()
                    .writeValueAsString(new Garbage());
            logger.debug(String.format("Derp  %s", v));

        } catch (java.io.IOException e) {
            logger.error(String.format("Derpfail %s", e.getMessage()));
        }
        return v;
    }


}
