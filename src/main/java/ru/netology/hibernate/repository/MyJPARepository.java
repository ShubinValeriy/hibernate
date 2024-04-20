package ru.netology.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonRequisites;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyJPARepository extends CrudRepository<Person, PersonRequisites> {
    List<Person> findPersonByCityOfLiving(String cityOfLiving);
    List<Person> findPersonByPersonRequisites_AgeLessThanOrderByPersonRequisites_Age(Integer age );
    Optional<Person> findPersonByPersonRequisites_NameAndPersonRequisites_Surname(String name, String surname);
}
