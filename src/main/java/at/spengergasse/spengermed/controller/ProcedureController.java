package at.spengergasse.spengermed.controller;
import at.spengergasse.spengermed.models.Patient;
import at.spengergasse.spengermed.models.Practitioner;
import at.spengergasse.spengermed.models.Procedure;
import at.spengergasse.spengermed.repositories.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping(path="/api/procedure")
@RestController
@CrossOrigin
public class ProcedureController {
    @Autowired
    private ProcedureRepository procedureRepository;

    @GetMapping
    public @ResponseBody Iterable<Procedure> getAllProcedures() {
        return procedureRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedure> getProcedure(@PathVariable String id) {
        return procedureRepository.findById(id).map(Procedure -> ResponseEntity.ok().body(Procedure)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Procedure> createProcedure(@RequestBody Procedure procedure) {
        procedure.setId(null);// ensure to create new names
        var saved = procedureRepository.save(procedure);
        return ResponseEntity.created(URI.create("/api/Procedure/" + saved.getId())).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Procedure> deleteProcedure(@PathVariable(value = "id") String pratictionerid) {
        return procedureRepository.findById(pratictionerid).map(procedure -> {
            procedureRepository.delete(procedure);
            return ResponseEntity.ok().<Procedure>build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Procedure> updatePrractitioner(@PathVariable(value = "id") String procedureid, @RequestBody Procedure procedureDetails) {
        return procedureRepository.findById(procedureid).map(procedure -> {
            procedure.setIdentifier(procedureDetails.getIdentifier());
            procedure.setStatus(procedureDetails.getStatus());
            procedure.setStatusWhy(procedureDetails.getStatusWhy());
            procedure.setPerformedAge(procedureDetails.getPerformedAge());
            procedure.setText(procedureDetails.getText());
            procedure.setPerformedRange(procedureDetails.getPerformedRange());
            Procedure updatedProcedure = procedureRepository.save(procedure);
            return ResponseEntity.ok(updatedProcedure);
        }).orElse(createProcedure(procedureDetails));
    }
}
