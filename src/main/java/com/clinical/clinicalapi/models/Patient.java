package com.clinical.clinicalapi.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "patient")
    // @JsonManagedReference
    @JsonIgnore
    private List<ClinicalData> clinicalData;

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ClinicalData> getClinicalData() {
        return clinicalData;
    }

}
