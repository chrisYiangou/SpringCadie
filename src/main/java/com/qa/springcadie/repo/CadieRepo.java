package com.qa.springcadie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springcadie.domain.Cadie;

@Repository
public interface CadieRepo extends JpaRepository<Cadie, Long>{
	
	//Method to retrieve Cadie and Friends - from database by their name
	public Cadie getCadieByName(String name);
	//To make at least three extra methods that can be used later when we initialise the methods in the Service
	
	
	// SELECT * FROM cadie; -- findAll();
	
	//Retrieve a Cadie - By any variable within it 
	//Use a Scanner/Logger to call upon variables within the Cadie Object - Cadies will then be added to the List and then be returned
	// This would be optimal in CLI - Not that optimal for GUI 
	//public List<Cadie> getByAnyVariable();
	
}
