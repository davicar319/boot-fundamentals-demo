package com.bixbysdoghouse.bootfundamentalsdemo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bixbysdoghouse.bootfundamentalsdemo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void greetWithoutName() {
        ResponseEntity<Greeting> greetingEntity = testRestTemplate.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, greetingEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, greetingEntity.getHeaders().getContentType());
        assertEquals(new Greeting("Hello, World!"), greetingEntity.getBody());
    }

    @Test
    void greetWithName() {
        ResponseEntity<Greeting> greetingEntity =
                testRestTemplate.getForEntity("/rest?name=Dave", Greeting.class);
        assertEquals(HttpStatus.OK, greetingEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, greetingEntity.getHeaders().getContentType());
        assertEquals(new Greeting("Hello, Dave!"), greetingEntity.getBody());
    }

}