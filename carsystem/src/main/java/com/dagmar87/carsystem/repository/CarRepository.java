package com.dagmar87.carsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dagmar87.carsystem.model.Car;

public interface CarRepository extends JpaRepository<Car, String>{
	
	List<Car> findByTitle(String title);

}
