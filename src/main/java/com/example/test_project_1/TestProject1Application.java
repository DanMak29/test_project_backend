package com.example.test_project_1;

import com.example.test_project_1.entity.City;
import com.example.test_project_1.entity.Country;
import com.example.test_project_1.repository.CityRepository;
import com.example.test_project_1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestProject1Application implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestProject1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Austria"));
        countryList.add(new Country("France"));
        countryList.add(new Country("Spain"));
        countryRepository.saveAll(countryList);

        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Vienna", 1L));
        cityList.add(new City("Salzburg", 1L));
        cityList.add(new City("Paris", 2L));
        cityList.add(new City("Lion", 2L));
        cityList.add(new City("Madrid", 3L));
        cityList.add(new City("Valencia", 3L));
        cityRepository.saveAll(cityList);
    }
}
