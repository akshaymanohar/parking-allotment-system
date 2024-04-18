package com.springboot.parking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vehical_details")
@NoArgsConstructor
@AllArgsConstructor
public class Vehical {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "vehical_owner")
    private String vehicalOwner;
    @Column(name = "vehical_number")
    private String vehicalNumber;
    @Column(name = "vehical_type")
    private String VehicalType;
    @Column(name = "in_time")
    private LocalDateTime inTime = LocalDateTime.now();
    @Column(name = "out_time")
    private LocalDateTime outTime;
}
