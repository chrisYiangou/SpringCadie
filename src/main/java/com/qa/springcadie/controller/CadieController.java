package com.qa.springcadie.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcadie.domain.Cadie;
import com.qa.springcadie.service.ServiceInterface;

@RestController
@RequestMapping("/cadie")
public class CadieController {
	
	//We need to understand HTTP requests 
	// What do we know? 
	
	//CRUD - So we use Responses to communicate from the API to the frontend 
	// So its the controllers responsibility to communicate and send these responses.
	//Where the Service class is doing the bulk of the lifting - the Controller's main task is to 
	// call upoun the service classs methods and create a response 
	
	// 200, 404, 300

	// 1XX Information 
	// 2XX is to say that there was a success -> You will be oblivious to this 
	// 3XX these are redirects - you should ve sent to another page 
	// 4XX Bad Request - 404 Error Not Found 
	// 5XX Server Error - Function isnt working, If something internally is just wrong.
	
	//Post - CREATE @POSTMAPPING 
	//Get - READ @GetMapping
	//Put/Patch - Update @PutMapping - Though PatchMapping is acceptable 
	//Delete - Delete @DeleteMapping 
	
	private ServiceInterface<Cadie> service;
	
	public CadieController(ServiceInterface service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Cadie> createCadie(@RequestBody Cadie cadie) {
		return new ResponseEntity<Cadie>(this.service.create(cadie), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Cadie>> readAllCadie() {
		return new ResponseEntity<List<Cadie>>(this.service.readAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Cadie> readByIdCadie(@PathVariable Long id) {
		return new ResponseEntity<Cadie>(this.service.readById(id), HttpStatus.FOUND);
	}
	
	//Create Update and Delete Response Entity Methods
	//Start this now and finish it for homework
	//We shall take the learning styles quiz
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Cadie> updateCadie(@PathVariable Long id, @RequestBody Cadie cadie) {
		return new ResponseEntity<Cadie>(this.service.update(id, cadie), HttpStatus.ACCEPTED);
		
	}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteCadie(@PathVariable Long id) {
		boolean deleted =  this.service.delete(id);
		
		return (deleted) 
		/* if true*/? new ResponseEntity<Boolean>(deleted, HttpStatus.OK)
		/*else*/	: new ResponseEntity<Boolean>(deleted, HttpStatus.NOT_FOUND);
	}
	
	

}
