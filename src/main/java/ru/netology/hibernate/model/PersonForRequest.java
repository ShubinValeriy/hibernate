package ru.netology.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonRequisites;

@AllArgsConstructor
@Data
public class PersonForRequest {
    private String name;
    private String surname;
    private Integer age;
    private String phone_number;
    private String city_of_living;

    public Person getPerson() {
        return new Person(
                new PersonRequisites(name, surname, age),
                phone_number,
                city_of_living);
    }
}
