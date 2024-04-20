package ru.netology.hibernate.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonRequisites;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyJPARepository extends CrudRepository<Person, PersonRequisites> {
//    List<Person> findPersonByCityOfLiving(String cityOfLiving);
//    List<Person> findPersonByPersonRequisites_AgeLessThanOrderByPersonRequisites_Age(Integer age );
//    List<Optional<Person>> findPersonByPersonRequisites_NameAndPersonRequisites_Surname(String name, String surname);
    @Query("SELECT p FROM Person p where p.cityOfLiving = :city")
    List<Person> findPersonFromCity(@Param("city") String city);

    @Query("SELECT p FROM Person p WHERE p.personRequisites.age < :age ORDER BY p.personRequisites.age ASC")
    List<Person> findPersonLessThan(@Param("age") Integer age);

    @Query ("SELECT p FROM Person p WHERE p.personRequisites.name = :name AND p.personRequisites.surname = :surname")
    List<Optional<Person>> findPersonByNameAndSurname(
            @Param("name") String name,
            @Param("surname") String surname
    );
}
