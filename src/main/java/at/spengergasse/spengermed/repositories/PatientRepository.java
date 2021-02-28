package at.spengergasse.spengermed.repositories;

import at.spengergasse.spengermed.models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,String> {
}
