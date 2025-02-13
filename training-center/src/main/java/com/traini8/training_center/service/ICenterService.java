package com.traini8.training_center.service;

import com.traini8.training_center.entity.Center;
import jakarta.validation.Valid;

import java.util.List;

//Service interface that defines business logic operations for managing entities.
public interface ICenterService {
	
	//Creates and saves a new training center.
    Center createCenter(@Valid Center center);
    
    //Retrieves a list of all training centers.
    List<Center> getAllCenters();
    
    //Retrieves a list of training centers located in a specific city.
    List<Center> getCentersByCity(String city);
    
    //Retrieves a list of training centers that offer at least one of the specified courses.
    List<Center> getCentersByCoursesOffered(List<String> courses);
}
