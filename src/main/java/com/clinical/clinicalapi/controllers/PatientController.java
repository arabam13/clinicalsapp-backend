package com.clinical.clinicalapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinical.clinicalapi.models.Patient;
import com.clinical.clinicalapi.repositories.PatientRepo;


@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepo patientRepo;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        System.out.println("##########################################");
        System.out.println("GET PATIENTS");
        System.out.println("##########################################");
        return patientRepo.findAll();
    }

    @PostMapping("/patients")
    public Patient createPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable("id") Integer id) {
        return patientRepo.findById(id).get();
    }
}
