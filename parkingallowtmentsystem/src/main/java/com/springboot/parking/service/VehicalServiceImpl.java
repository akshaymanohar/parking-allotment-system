package com.springboot.parking.service;

import com.springboot.parking.exception.ResourceAlreadyExist;
import com.springboot.parking.repository.VehicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springboot.parking.entity.Vehical;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class VehicalServiceImpl {

    @Autowired
    VehicalRepository vehicalRepository;

    public Vehical saveDetails(Vehical vehical){
        Vehical vehicalEntity = vehicalRepository.findByVehicalNumber(vehical.getVehicalNumber());
        if(vehicalEntity != null){
            throw new ResourceAlreadyExist("vehical already resistered for parking");
        }
        return vehicalRepository.save(vehical);
    }

    public List<Vehical> getAllVehicals(){
        return vehicalRepository.findAll();
    }

    public Vehical getByVehicalNumber(String vehicalNumber){
        return vehicalRepository.findByVehicalNumber(vehicalNumber);
    }

    public Vehical updateVehicalDetails(Vehical vehical){
        Optional<Vehical> existingVehical = vehicalRepository.findById(vehical.getId());
        Vehical eVValue = existingVehical.get();

        eVValue.setVehicalType(vehical.getVehicalType());
        eVValue.setVehicalOwner(vehical.getVehicalOwner());
        eVValue.setVehicalNumber(vehical.getVehicalNumber());
        return vehicalRepository.save(eVValue);
    }

    public String deleteVehicalEntry(int id){
        vehicalRepository.deleteById(id);
        return "Entry has been deleted successfully";
    }

    public String exitVehical(Vehical vehical){
        Optional<Vehical> existing = vehicalRepository.findById(vehical.getId());
        Vehical eVehical = existing.get();
        eVehical.setOutTime(LocalDateTime.now());
        vehicalRepository.save(eVehical);

        return "Exit time has been updated for vehical"+ eVehical.getVehicalNumber();
    }
}
