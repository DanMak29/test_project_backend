package com.example.test_project_1.controllers;

import com.example.test_project_1.entity.City;
import com.example.test_project_1.entity.Country;
import com.example.test_project_1.entity.Employee;
import com.example.test_project_1.entity.EmployeeDTO;
import com.example.test_project_1.services.MainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> findAll() {
        return mainService.findAll();
    }

    @GetMapping("/countries")
    public List<Country> findCountriesAll() {
        return mainService.getCountries();
    }

    @PostMapping("/employees")
    public void createEmployeeForm(@RequestBody Employee employee) {
        mainService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        mainService.deleteEmployeeById(id);
    }

    @GetMapping("/cities")
    public List<City> getCities(@RequestParam Long countryId) {
        return mainService.getCityByCountryId(countryId);
    }

    @GetMapping("/employees/name")
    public List<EmployeeDTO> findByName(@RequestParam String name) {
        return mainService.findEmployeeByName(name);
    }
}
