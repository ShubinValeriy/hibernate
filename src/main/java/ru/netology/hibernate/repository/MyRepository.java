package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;

@Repository
public class MyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Person addPerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery(
                "select p from Person p where p.city_of_living = " + "'" + city + "'", Person.class
        ).getResultList();
    }

}
