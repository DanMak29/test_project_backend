package com.example.test_project_1.repository;

import com.example.test_project_1.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCountry(Long id);
}
