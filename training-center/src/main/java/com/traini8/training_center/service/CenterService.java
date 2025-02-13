package com.traini8.training_center.service;

import com.traini8.training_center.entity.Center;
import com.traini8.training_center.repository.CenterRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

// Service class responsible for handling business logic related to entities.

@Service
@Validated
public class CenterService implements ICenterService {

    private final CenterRepository centerRepository;
    
    // Constructor-based dependency injection
    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }
    
    // Saves a new training center to the database.
    @Override
    public Center createCenter(@Valid Center center) {
        return centerRepository.save(center);
    }
    
    // Retrieves all training centers from the database.
    @Override
    public List<Center> getAllCenters() {
        List<Center> centerList = centerRepository.findAll();
        return centerList.isEmpty() ? Collections.emptyList() : centerList;
    }
    
    // Retrieves a list of training centers located in a specific city.
	@Override
	public List<Center> getCentersByCity(String city) {
		return centerRepository.findByAddress_City(city);
	}
	
	// Retrieves a list of training centers that offer at least one of the specified courses.
	@Override
	public List<Center> getCentersByCoursesOffered(List<String> courses) {
		return centerRepository.findByCoursesOffered(courses);
	}
}
