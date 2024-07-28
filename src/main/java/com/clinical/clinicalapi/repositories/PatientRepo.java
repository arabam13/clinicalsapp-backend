package com.clinical.clinicalapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinical.clinicalapi.models.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
    
}
