package at.spengergasse.spengermed.controller;
import at.spengergasse.spengermed.models.Patient;
import at.spengergasse.spengermed.models.Practitioner;
import at.spengergasse.spengermed.repositories.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping(path="/api/practitioner")
@RestController
@CrossOrigin
public class PractitionerController {
    @Autowired
    private PractitionerRepository practitionerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Practitioner> getPractitioner(@PathVariable String id) {
        return practitionerRepository.findById(id).map(practitioner -> ResponseEntity.ok().body(practitioner)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public @ResponseBody Iterable<Practitioner> getAllPractitioners() {
        return practitionerRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity<Practitioner> createPractitioner(@RequestBody Practitioner practitioner) {
        practitioner.setId(null);// ensure to create new names
        var saved = practitionerRepository.save(practitioner);
        return ResponseEntity.created(URI.create("/api/practitioner/" + saved.getId())).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Practitioner> deletePractitioner(@PathVariable(value = "id") String pratictionerid) {
        return practitionerRepository.findById(pratictionerid).map(practitioner -> {
            practitionerRepository.delete(practitioner);
            return ResponseEntity.ok().<Practitioner>build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practitioner> updatePrractitioner(@PathVariable(value = "id") String practitionerid, @RequestBody Practitioner practitionerDetails) {
        return practitionerRepository.findById(practitionerid).map(practitioner -> {
            practitioner.setActive(practitionerDetails.isActive());
            practitioner.setGender(practitionerDetails.getGender());
            practitioner.setIdentifier(practitionerDetails.getIdentifier());
            practitioner.setName(practitionerDetails.getName());
            practitioner.setAddress(practitionerDetails.getAddress());
            practitioner.setBirthDate(practitionerDetails.getBirthDate());
            practitioner.setText(practitionerDetails.getText());
            practitioner.setTelecom(practitionerDetails.getTelecom());
            practitioner.setCommunication(practitionerDetails.getCommunication());
            practitioner.setPhoto(practitionerDetails.getPhoto());
            practitioner.setQualification(practitionerDetails.getQualification());
            Practitioner updatedPractitioner = practitionerRepository.save(practitioner);
            return ResponseEntity.ok(updatedPractitioner);
        }).orElse(createPractitioner(practitionerDetails));
    }
}
