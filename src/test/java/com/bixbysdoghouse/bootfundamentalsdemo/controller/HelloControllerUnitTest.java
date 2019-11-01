package com.bixbysdoghouse.bootfundamentalsdemo.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

class HelloControllerUnitTest {

    @Test
    void sayHello() {
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = helloController.sayHello("World", model);
        assertEquals("hello", result);
        assertEquals("World", model.asMap().get("user"));
    }

}