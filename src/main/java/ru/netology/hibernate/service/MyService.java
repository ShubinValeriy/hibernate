package ru.netology.hibernate.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.MyJPARepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<Person> personsByCity = myRepository.findPersonFromCity(city);
        if (personsByCity.isEmpty()) {
            return new ResponseEntity<>("PERSON NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personsByCity.toString(), HttpStatus.OK);
    }

    public ResponseEntity<String> getPersonsByAgeLessThan(Integer age) {
        List<Person> personsByAge = myRepository
                .findPersonLessThan(age);
        if (personsByAge.isEmpty()) {
            return new ResponseEntity<>("PERSON NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personsByAge.toString(), HttpStatus.OK);
    }


    public ResponseEntity<String> getPersonsByNameAndSurname(String name, String surname) {
       List<Optional<Person>> personsByNameAndSurname = myRepository
                .findPersonByNameAndSurname(
                        name, surname
                );
        if (personsByNameAndSurname.isEmpty()) {
            return new ResponseEntity<>("PERSON NOT FOUND", HttpStatus.NOT_FOUND);
        }else {
            List<Person> personList = new ArrayList<>();
            for (Optional<Person> person:personsByNameAndSurname){
                personList.add(person.get());
            }
            return new ResponseEntity<>(personList.toString(), HttpStatus.OK);
        }

    }

}
