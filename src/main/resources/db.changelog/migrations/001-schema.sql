create schema datafortest;

create table datafortest.PERSONS(
                             name VARCHAR NOT NULL ,
                             surname VARCHAR NOT NULL ,
                             age INT NOT NULL ,
                             phone_number VARCHAR NOT NULL ,
                             city_of_living VARCHAR NOT NULL ,
                             PRIMARY KEY (name, surname, age)
);