package com.bixbysdoghouse.bootfundamentalsdemo.controller;

import com.bixbysdoghouse.bootfundamentalsdemo.entities.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    private Logger log = LoggerFactory.getLogger(HelloRestController.class);

    @GetMapping("/rest")
    public Greeting greet(@RequestParam(required = false, defaultValue = "World") String name) {
        log.debug(">>>greet: name={}", name);
        Greeting response = new Greeting(String.format("Hello, %s!", name));
        log.info("<<<greet: name={} -> {}", name, response);
        return response;
    }
}
