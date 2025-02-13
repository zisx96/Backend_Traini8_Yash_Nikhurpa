package com.traini8.training_center.controller;

import com.traini8.training_center.entity.Center;
import com.traini8.training_center.service.ICenterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Rest Controller for managing Training Centers. Handles API request related to create and retrieve centers.

@RestController
@RequestMapping("api/centers") // Base URL for all endpoints
public class CenterController {

    private final ICenterService centerService;

    public CenterController(ICenterService centerService) {
        this.centerService = centerService;
    }
    
    // Creates a new Center

    @PostMapping
    public ResponseEntity<Center> addCenter(@Valid @RequestBody Center center){

        Center center1 = centerService.createCenter(center);

        return new ResponseEntity<>(center1, HttpStatus.CREATED);
    }
    
    // Retrieves a list of Training Centers.
    
    @GetMapping
    public ResponseEntity<List<Center>> getAllCenters(@RequestParam(required = false) String city,
    		@RequestParam(required = false) List<String> courses){
    	
    	// If city is provided, return centers from that city
    	
    	if(city != null) {
    		
    		return new ResponseEntity<>(centerService.getCentersByCity(city), HttpStatus.OK);
    	}
    	
    	 // If courses are provided, return centers offering those courses
    	
    	if(courses != null && !courses.isEmpty()) {
    		
    		return new ResponseEntity<>(centerService.getCentersByCoursesOffered(courses), HttpStatus.OK);
    	}
    	
    	// If no filters are provided, return all centers

        List<Center> centerList = centerService.getAllCenters();

        return new ResponseEntity<>(centerList, HttpStatus.OK);
    }
}
