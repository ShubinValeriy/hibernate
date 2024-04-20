package ru.netology.hibernate.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.MyJPARepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MyService {
    private final MyJPARepository myRepository;

    public MyService(MyJPARepository myRepository) {
        this.myRepository = myRepository;
    }

    public Person addPerson(Person person) {
        return myRepository.save(person);
    }

    public ResponseEntity<String> getPersonsByCity(String city) {
        List<Person> personsByCity = myRepository.findPersonByCityOfLiving(city);
        if (personsByCity.isEmpty()) {
            return new ResponseEntity<>("PERSON NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personsByCity.toString(), HttpStatus.OK);
    }

    public ResponseEntity<String> getPersonsByAgeLessThan(Integer age) {
        List<Person> personsByAge = myRepository
                .findPersonByPersonRequisites_AgeLessThanOrderByPersonRequisites_Age(age);
        if (personsByAge.isEmpty()) {
            return new ResponseEntity<>("PERSON NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personsByAge.toString(), HttpStatus.OK);
    }


    public ResponseEntity<String> getPersonsByNameAndSurname(String name, String surname) {
       Optional<Person> personsByNameAndSurname = myRepository
                .findPersonByPersonRequisites_NameAndPersonRequisites_Surname(
                        name, surname
                );
        if (personsByNameAndSurname.isEmpty()) {
            return new ResponseEntity<>("PERSON NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personsByNameAndSurname.get().toString(), HttpStatus.OK);
    }

}
