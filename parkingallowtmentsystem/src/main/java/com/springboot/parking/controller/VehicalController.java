package com.springboot.parking.controller;

import com.springboot.parking.entity.Vehical;
import com.springboot.parking.service.VehicalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehical")
public class VehicalController {

    @Autowired
    VehicalServiceImpl vehicalService;

    @PostMapping("/save")
    public ResponseEntity<Vehical> saveVehical(@RequestBody Vehical vehical){
        return ResponseEntity.status(HttpStatus.OK).body(vehicalService.saveDetails(vehical));
    }

    @GetMapping("/get-all-vehicals")
    public List<Vehical> getAllVehicals(){
       return vehicalService.getAllVehicals();
    }

    @GetMapping("/getByVehcialNumber/{vehicalNumber}")
    public Vehical getByVehicalNumber(@PathVariable String vehicalNumber){
        return vehicalService.getByVehicalNumber(vehicalNumber);
    }

    @PutMapping("/update")
    public Vehical UpdateVehicalDetails(@RequestBody Vehical vehical){
        return vehicalService.updateVehicalDetails(vehical);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteEntry(@PathVariable int id){
        return vehicalService.deleteVehicalEntry(id);
    }

    @PutMapping("/exit")
    public void exitVehical(@RequestBody Vehical vehical){
        vehicalService.exitVehical(vehical);
    }
}
