package com.clinical.clinicalapi.controllers;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinical.clinicalapi.dto.ClinicalDTO;
import com.clinical.clinicalapi.models.ClinicalData;
import com.clinical.clinicalapi.models.Patient;
import com.clinical.clinicalapi.repositories.ClinicalDataRepo;
import com.clinical.clinicalapi.repositories.PatientRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

    private final ClinicalDataRepo clinicalDataRepo;
    private final PatientRepo patientRepo;
    public ClinicalDataController(ClinicalDataRepo clinicalDataRepo, PatientRepo patientRepo) {
        this.clinicalDataRepo = clinicalDataRepo;
        this.patientRepo = patientRepo;
    }
    
    @PostMapping("/clinicals")
    public ClinicalData createClinicalData(@Valid @RequestBody ClinicalDTO dto) {
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(dto.componentName());
        clinicalData.setComponentValue(dto.componentValue());

        // Define the formatter for the input string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        // Parse the string to LocalDateTime
        try {
            // Parse the string to LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.parse(dto.measuredDateTime(), formatter);
            // Convert LocalDateTime to Timestamp
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            clinicalData.setMeasuredDateTime(timestamp);
        } catch (DateTimeParseException e) {
            // Handle the exception, e.g., log the error or throw a custom exception
            throw new IllegalArgumentException("Invalid date format: " + dto.measuredDateTime(), e);
        }

        Integer patientId = Integer.valueOf(dto.patientId());
        // Associer le patient
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient ID n'existe pas dans la base de données."));
        clinicalData.setPatient(patient);

        return clinicalDataRepo.save(clinicalData);

    }
}
