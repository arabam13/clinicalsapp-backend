package com.clinical.clinicalapi.dto;

import jakarta.validation.constraints.NotEmpty;

public record ClinicalDTO(
    @NotEmpty
    String componentName,
    @NotEmpty
    String componentValue,
    @NotEmpty
    String measuredDateTime,
    @NotEmpty
    String patientId
) {
    
}
