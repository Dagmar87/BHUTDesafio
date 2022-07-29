package com.dagmar87.carsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dagmar87.carsystem.model.Car;
import com.dagmar87.carsystem.repository.CarRepository;

@CrossOrigin(origins = "http://api-test.bhut.com.br:3000")
@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	CarRepository carRep;
	
	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAll(@RequestParam(required = false) String title) {
		try {
			List<Car> cars = new ArrayList<Car>();
			if (title == null)
				carRep.findAll().forEach(cars::add);
			else
				carRep.findByTitle(title).forEach(cars::add);
			if (cars.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cars, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getById(@PathVariable("id") String id) {
		Optional<Car> carData = carRep.findById(id);
		if (carData.isPresent()) {
			return new ResponseEntity<>(carData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Car> create(@Valid @RequestBody Car car) {
		try {
			Car _car = carRep
					.save(new Car(car.getTitle(), car.getBrand(), car.getPrice(), car.getAge()));
			return new ResponseEntity<>(_car, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<Car> update(@PathVariable("id") String id, @Valid @RequestBody Car car) {
		Optional<Car> carData = carRep.findById(id);
		if (carData.isPresent()) {
			Car _car = carData.get();
			_car.setTitle(car.getTitle());
			_car.setBrand(car.getBrand());
			_car.setPrice(car.getPrice());;
			_car.setAge(car.getAge());;			
			return new ResponseEntity<>(carRep.save(_car), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
		try {
			carRep.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
