package dev.revived.touroftacos;

import dev.revived.touroftacos.controller.DerpController;
import org.jsoup.Jsoup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@SpringBootTest
@AutoConfigureMockMvc
class TourOfTacosApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DerpController derp;


    @Test
    void contextLoads() {
        assertTrue(derp.gogogogo().contains("aaa"));
    }

    @Test
    void gribViewSaysGrib() throws Exception {
        ResultActions grib = mockMvc.perform(get("/frum/grib"));

        grib.andExpect(content().string(containsString("gribviewm")));

    }

    @Test
    void gribIntegration() throws Exception {

        var response = mockMvc.perform(get("/frum/grib"))
                .andReturn().getResponse().getContentAsString();
        String texts = Jsoup.parse(response)
                .select("[datatest-id='grib']")
                .text();
        assertTrue(texts.contains("grib"));
    }

    @Test
    void gribXpath() throws Exception {

        mockMvc.perform(get("/frum/grib"))
                .andExpect(xpath("//span[@datatest-id='grib'][last()]")
                        .string(containsString("grib")));
    }


}
