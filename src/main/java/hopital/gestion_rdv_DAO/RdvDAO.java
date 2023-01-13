package hopital.gestion_rdv_DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hopital.gestion_rdv_models.Rdv;
@Repository
public interface RdvDAO extends CrudRepository<Rdv, Long>{

}
