package com.example.test_project_1.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "email")
    private String email;

    @Column(name = "country_id")
    private Long countryId;


    @Column(name = "city_id")
    private Long cityId;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountry(Long countryId) {
        this.countryId = countryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCity(Long cityId) {
        this.cityId = cityId;
    }
}
