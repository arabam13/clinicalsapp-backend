package com.clinical.clinicalapi.dto;

import java.util.List;

import com.clinical.clinicalapi.models.ClinicalData;

public record PatientResponseDTO(
    int id,
    String firstName,
    String lastName,
    int age,
    List<ClinicalData> clinicalData
) {
    
}
