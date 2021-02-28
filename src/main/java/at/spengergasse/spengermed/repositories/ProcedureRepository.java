package at.spengergasse.spengermed.repositories;

import at.spengergasse.spengermed.models.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface ProcedureRepository extends CrudRepository<Procedure,String> {

}
