package com.example.test_project_1.repository;

import com.example.test_project_1.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country getById(Country country);
}
