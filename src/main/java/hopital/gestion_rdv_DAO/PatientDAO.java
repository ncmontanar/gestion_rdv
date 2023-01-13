package hopital.gestion_rdv_DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hopital.gestion_rdv_models.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long> {

}
