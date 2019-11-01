package com.bixbysdoghouse.bootfundamentalsdemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
class HelloControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloWithoutName() throws Exception {
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
               .andExpect(status().isOk())
               .andExpect(view().name("hello"))
               .andExpect(model().attribute("user", Matchers.is("World")));
    }

    @Test
    void testHelloWithName() throws Exception {
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN).param("name", "Dave"))
               .andExpect(status().isOk())
               .andExpect(view().name("hello"))
               .andExpect(model().attribute("user", Matchers.is("Dave")));
    }
}