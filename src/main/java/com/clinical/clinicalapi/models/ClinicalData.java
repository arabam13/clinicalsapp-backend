package com.clinical.clinicalapi.models;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
// @JsonIgnoreProperties({"patient"})
public class ClinicalData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String componentName;
    private String componentValue;
    private Timestamp measuredDateTime;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable=false)
    // @JsonBackReference
    private Patient patient;

    public ClinicalData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentValue() {
        return componentValue;
    }

    public void setComponentValue(String componentValue) {
        this.componentValue = componentValue;
    }

    public Timestamp getMeasuredDateTime() {
        return measuredDateTime;
    }

    public void setMeasuredDateTime(Timestamp measuredDateTime) {
        this.measuredDateTime = measuredDateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

}
