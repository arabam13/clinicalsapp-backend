package com.clinical.clinicalapi.controllers;
// package com.clinical.api.endpoints;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.clinical.api.models.Patient;
// import com.clinical.api.repositories.PatientRepo;

// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.GET;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.PathParam;
// import jakarta.ws.rs.Produces;


// @Consumes("application/json")
// @Produces("application/json")
// @Path("/api")
// public class PatientService {

//     @Autowired
//     PatientRepo patientRepo;

//     @Path("/patients")
//     @GET
//     public List<Patient> getPatients() {
//         System.out.println("##########################################");
//         System.out.println("GET PATIENTS");
//         System.out.println("##########################################");
//         return patientRepo.findAll();
//     }

//     @Path("/patients")
//     @POST
//     public Patient createPatient(Patient patient) {
//         return patientRepo.save(patient);
//     }

//     @Path("/patients/{id}")
//     @GET
//     public Patient getPatient(@PathParam("id") Integer id) {
//         return patientRepo.findById(id).get();
//     }
// }
