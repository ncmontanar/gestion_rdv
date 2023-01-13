package hopital.gestion_rdv_services;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import hopital.gestion_rdv_DAO.RdvDAO;
import hopital.gestion_rdv_models.Rdv;

public class RdvServiceImpl implements RdvService {
	
	@Autowired
	private RdvDAO rdvDao;

	//avoir_liste_rdv_Impl
	@Override
	public List<Rdv> getIdRdvList() {

		List<Rdv> rdvListe = (List<Rdv>) rdvDao.findAll();
		if(!rdvListe.isEmpty()) {
			return rdvListe;
		}
		else {
		return null;
		}
	}

	
	//enregistrer_une_rdv_Impl	
	@Override
	public Rdv saveRdv(Rdv rdv) {
		return rdvDao.save(rdv);
	}

	//trouver_une_rdv8_impl
	@Override
	public Rdv findRdvById(Long id) {
		
		Optional<Rdv> retrieveRdv = rdvDao.findById(id);
		if(retrieveRdv.isPresent()) {
			return retrieveRdv.get();
		}
		else {
			return null;
		}
	}

	//màj_une_rdv_impl
	public Rdv updateRdv(Long id, Rdv rdv) {
		Optional<Rdv> retrieveRdv = rdvDao.findById(id);
		
		Rdv _rdv = retrieveRdv.get();
		_rdv.setDateRdv(rdv.getDateRdv());
		rdvDao.save(_rdv);
		return _rdv;
	}
	
	
	
	


	//affacer_une_rdv_impl
	@Override
	public void deleteById(Long id) {
		rdvDao.deleteById(id);
		
	}

}
