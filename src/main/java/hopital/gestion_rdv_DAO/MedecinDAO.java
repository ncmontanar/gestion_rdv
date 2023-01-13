package hopital.gestion_rdv_DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hopital.gestion_rdv_models.Medecin;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long>{

}
