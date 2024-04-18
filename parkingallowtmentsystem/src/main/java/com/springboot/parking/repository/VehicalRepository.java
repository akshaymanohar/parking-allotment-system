package com.springboot.parking.repository;

import com.springboot.parking.entity.Vehical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicalRepository extends JpaRepository<Vehical,Integer> {
    Vehical findByVehicalNumber(String vehicalNumber);
}
