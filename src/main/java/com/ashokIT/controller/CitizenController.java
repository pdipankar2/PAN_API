package com.ashokIT.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokIT.Entity.Citizen;
import com.ashokIT.service.CitizenService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController

public class CitizenController {
	

	    @Autowired
	    private CitizenService citizenService;

	    // POST method to add a new citizen
	    @PostMapping("/citizen")
	    public ResponseEntity<Citizen> createCitizen( @RequestBody Citizen citizen) {
	        return ResponseEntity.ok(citizenService.saveCitizen(citizen));
	    }

	    // GET method to fetch citizen by SSN
	    @GetMapping("/citizen/{pan}")
	    public ResponseEntity<Citizen> getCitizenByPAN(@PathVariable String pan) {
	        Optional<Citizen> citizen = citizenService.getCitizenByPAN(pan);
	        return citizen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	
	
	
	
	

}
