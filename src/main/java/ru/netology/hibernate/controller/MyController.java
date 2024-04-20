package ru.netology.hibernate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.model.PersonForRequest;
import ru.netology.hibernate.service.MyService;

@RestController
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @PostMapping("add/person")
    public Person addPerson(@RequestBody PersonForRequest personForRequest) {
        System.out.println(personForRequest);
        return service.addPerson(personForRequest.getPerson());
    }

    @GetMapping("persons/by-city")
    public ResponseEntity<String> getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

}
