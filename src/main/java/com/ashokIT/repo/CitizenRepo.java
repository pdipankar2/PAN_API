package com.ashokIT.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokIT.Entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

    Optional<Citizen> findByPan(String pan);  // Find citizen by pan
	
}
