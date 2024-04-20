package ru.netology.hibernate.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.MyRepository;

import java.util.List;

@Service
public class MyService {
    private final MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public Person addPerson(Person person) {
        return myRepository.addPerson(person);
    }

    public ResponseEntity<String> getPersonsByCity(String city) {
        List<Person> personsByCity = myRepository.getPersonsByCity(city);
        if (personsByCity.isEmpty()) {
            return new ResponseEntity<>("PERSON NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personsByCity.toString(), HttpStatus.OK);
    }

}
