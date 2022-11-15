package com.example.test_project_1.services;

import com.example.test_project_1.entity.City;
import com.example.test_project_1.entity.Country;
import com.example.test_project_1.entity.Employee;
import com.example.test_project_1.entity.EmployeeDTO;
import com.example.test_project_1.repository.CityRepository;
import com.example.test_project_1.repository.CountryRepository;
import com.example.test_project_1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final EmployeeRepository employeeRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public MainService(EmployeeRepository employeeRepository, CountryRepository countryRepository, CityRepository cityRepository) {
        this.employeeRepository = employeeRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public List<EmployeeDTO> findAll() {
         return employeeRepository.findAll().stream().map(value -> {
             EmployeeDTO employeeDTO = new EmployeeDTO();
             employeeDTO.setId(value.getId());
             employeeDTO.setSurname(value.getSurname());
             employeeDTO.setName(value.getName());
             employeeDTO.setNumber(value.getNumber());
             employeeDTO.setEmail(value.getEmail());
             Country country = countryRepository.getById(value.getCountryId());
             employeeDTO.setCountry(country.getName());
             City city = cityRepository.getById(value.getCityId());
             employeeDTO.setCity(city.getName());
             return employeeDTO;
         }).collect(Collectors.toList());
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public List<City> getCityByCountryId(Long countryId) {
        return cityRepository.findAllByCountry(countryId);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<EmployeeDTO> findEmployeeByName(String name) {
        return employeeRepository.findByName(name).stream().map(value -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(value.getId());
            employeeDTO.setSurname(value.getSurname());
            employeeDTO.setName(value.getName());
            employeeDTO.setNumber(value.getNumber());
            employeeDTO.setEmail(value.getEmail());
            Country country = countryRepository.getById(value.getCountryId());
            employeeDTO.setCountry(country.getName());
            City city = cityRepository.getById(value.getCityId());
            employeeDTO.setCity(city.getName());
            return employeeDTO;
        }).collect(Collectors.toList());
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
