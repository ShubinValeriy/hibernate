package ru.netology.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Persons")
public class Person {
    @EmbeddedId
    private PersonRequisites personRequisites;
    @Column(nullable = false)
    private String phone_number;
    @Column(nullable = false)
    private String city_of_living;
}
