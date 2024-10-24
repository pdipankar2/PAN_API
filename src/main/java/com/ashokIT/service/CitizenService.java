package com.ashokIT.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokIT.Entity.Citizen;
import com.ashokIT.repo.CitizenRepo;

import jakarta.validation.Valid;

@Service
public class CitizenService{

	
	  @Autowired
	    private CitizenRepo citizenRepository;

	

	    public Citizen saveCitizen(Citizen citizen) {
	        // Set the state based on PAN
	        String stateName = determineStateFromSSN(citizen.getPan());
	        citizen.setStateName(stateName);
	        return citizenRepository.save(citizen);
	    }

	    public Optional<Citizen> getCitizenByPAN(String pan) {
	        return citizenRepository.findByPan(pan);
	    }

	    // Determine state based on the first digit of PAN
	    private String determineStateFromSSN(String pan) {
	        char firstDigit = pan.charAt(0);
	        switch (firstDigit) {
	            case '1': return "New Delhi";
	            case '2': return "WestBengal";
	            case '3': return "Orissa";
	            case '4': return "Andhra Pradesh";
	            case '5': return "Maharastra ";
	            case '6': return "Karnatak";
	            default: throw new IllegalArgumentException("Invalid PAN: " + pan);
	        }
	    }
	}
	
	

	


