package com.qa.springcadie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.springcadie.domain.Cadie;
import com.qa.springcadie.repo.CadieRepo;

@Service
public class CadieService implements ServiceInterface<Cadie> {
	
	private CadieRepo cadieRepo; //Enacts the required methods needed to save things into our database 
	
	public CadieService(CadieRepo cadieRepo) {
		this.cadieRepo = cadieRepo;
	}
	
	@Override
	public Cadie create(Cadie cadie) {
		return this.cadieRepo.save(cadie);
	}

	@Override
	public List<Cadie> readAll() {
		return this.cadieRepo.findAll(); //This method is calling the instance of the Repository, after, it is calling the method findall
										// After this the result is shared through the return statement
		//System.out.println -- Printing it to the console - Benefits us as we have eyes, computers dont.
		//return -- printing for the computer to see - the value can be used 
	}

	@Override
	public Cadie readById(Long id) {
		Optional<Cadie> optionalCadie = this.cadieRepo.findById(id);
		return optionalCadie.get();
		
	}

	@Override
	public Cadie update(Long id, Cadie cadie) {
		Optional<Cadie> optionalCadie = this.cadieRepo.findById(id);
		if (optionalCadie.isPresent()) {
			Cadie existingCadie = optionalCadie.get();
			existingCadie.setName(cadie.getName());
			existingCadie.setAge(cadie.getAge());
			return this.cadieRepo.save(existingCadie);
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		
		this.cadieRepo.deleteById(id);
		
		return !this.cadieRepo.existsById(id);
	}

	
	
}
