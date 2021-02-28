package at.spengergasse.spengermed.repositories;

import at.spengergasse.spengermed.models.Practitioner;
import org.springframework.data.repository.CrudRepository;

public interface PractitionerRepository extends CrudRepository<Practitioner,String> {

}
