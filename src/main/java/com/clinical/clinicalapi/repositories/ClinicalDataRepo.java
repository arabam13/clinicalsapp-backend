package com.clinical.clinicalapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinical.clinicalapi.models.ClinicalData;


public interface ClinicalDataRepo extends JpaRepository<ClinicalData, Integer>{
    
}