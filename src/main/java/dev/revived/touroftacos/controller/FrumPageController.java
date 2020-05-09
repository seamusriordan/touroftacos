package dev.revived.touroftacos.controller;

import dev.revived.touroftacos.service.HelpfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/frum")
public class FrumPageController {
    private HelpfulService helpfulService;

    @Autowired
    public FrumPageController(HelpfulService helpfulService) {
        this.helpfulService = helpfulService;
    }

    @RequestMapping("")
    public @ResponseBody
    String frum(@RequestParam(value = "frumid", required = false, defaultValue = "") String id) {
        return "<html><head><title>WELOME TO FRUM</title> <link rel=\"stylesheet\" type=\"text/css\" href=\"frum.css\"></head><body><div class=\"frum\">frum" + id + "</div></body></html>";
    }

    @RequestMapping("/grib")
    public String grib(Model model) {
        model.addAttribute("gribkey", "gribviewm");
        model.addAttribute("help", helpfulService.getHelp());
        return "gribview";
    }
}
