package com.traini8.training_center.repository;

import com.traini8.training_center.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// Repository interface for managing entities.

@Repository
public interface CenterRepository extends JpaRepository<Center, UUID> {
	
	//Finds a list of training centers located in a specific city.
	List<Center> findByAddress_City(String city);
	
	
	// Finds training centers that offer at least one of the specified courses.
	@Query("SELECT c FROM Center c JOIN c.coursesOffered co WHERE co IN :courses")
    List<Center> findByCoursesOffered(@Param("courses") List<String> courses);
	
}
