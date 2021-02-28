package at.spengergasse.spengermed.controller;

import at.spengergasse.spengermed.models.Patient;
import at.spengergasse.spengermed.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping(path="/api/patient")
@RestController
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public @ResponseBody Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable String id) {
        return patientRepository.findById(id).map(patient -> ResponseEntity.ok().body(patient)).orElse(ResponseEntity.notFound().build());
    }

    //TODO: AllMethode einfügen

    // Create a new Patient
    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        patient.setId(null);// ensure to create new names
        var saved = patientRepository.save(patient);
        return ResponseEntity.created(URI.create("/api/patient/" + saved.getId())).body(saved);
    }

    // Delete a Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable(value = "id") String patientId) {
        return patientRepository.findById(patientId).map(patient -> {
            patientRepository.delete(patient);
            return ResponseEntity.ok().<Patient>build();
        }).orElse(ResponseEntity.notFound().build());
    }

    // Update a Patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") String patientId, @RequestBody Patient patientDetails) {
        return patientRepository.findById(patientId).map(patient -> {
            patient.setActive(patientDetails.isActive());
            patient.setGender(patientDetails.getGender());
            patient.setIdentifier(patientDetails.getIdentifier());
            patient.setName(patientDetails.getName());
            patient.setAddress(patientDetails.getAddress());
            patient.setBirthDate(patientDetails.getBirthDate());
            patient.setText(patientDetails.getText());
            patient.setTelecom(patientDetails.getTelecom());
            patient.setDeceasedDateTime(patientDetails.getDeceasedDateTime());
            patient.setDeceasedBoolean(patientDetails.isDeceasedBoolean());
            Patient updatedPatient = patientRepository.save(patient);
            return ResponseEntity.ok(updatedPatient);
        }).orElse(createPatient(patientDetails));
    }
}