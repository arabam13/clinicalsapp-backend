package com.clinical.clinicalapi.dto;

import jakarta.validation.constraints.NotEmpty;

public record PatientDTO(
    @NotEmpty
    String firstName,
    @NotEmpty
    String lastName,
    @NotEmpty
    String age
) {
    
}
