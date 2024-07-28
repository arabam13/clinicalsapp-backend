package com.clinical.clinicalapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinical.clinicalapi.dto.PatientDTO;
import com.clinical.clinicalapi.mappers.PatientMapper;
import com.clinical.clinicalapi.models.Patient;
import com.clinical.clinicalapi.repositories.PatientRepo;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    PatientMapper patientMapper;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    @PostMapping("/patients")
    public Patient createPatient(@Valid @RequestBody PatientDTO dto) {
        return patientMapper.toPatient(dto);
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable("id") Integer id) {
        return patientRepo.findById(id).get();
    }
}
