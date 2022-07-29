package com.dagmar87.carsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dagmar87.carsystem.model.Log;

public interface LogRepository extends JpaRepository<Log, String>{

}
