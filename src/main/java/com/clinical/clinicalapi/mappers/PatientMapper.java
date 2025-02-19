package com.clinical.clinicalapi.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinical.clinicalapi.dto.PatientDTO;
import com.clinical.clinicalapi.dto.PatientResponseDTO;
import com.clinical.clinicalapi.models.Patient;
import com.clinical.clinicalapi.repositories.PatientRepo;

@Service
public class PatientMapper {

    @Autowired
    PatientRepo patientRepo;
    
    public Patient toPatient(PatientDTO dto){
        Patient patient = new Patient();
        patient.setFirstName(dto.firstName());
        patient.setLastName(dto.lastName());
        Integer age = Integer.valueOf(dto.age());
        patient.setAge(age);
        return patientRepo.save(patient);
    }

    public PatientResponseDTO toResponsePatient(Patient patient){
        return new PatientResponseDTO(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getClinicalData());
    }
    
}
