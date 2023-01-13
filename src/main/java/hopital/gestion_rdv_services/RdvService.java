package hopital.gestion_rdv_services;

import java.util.List;

import hopital.gestion_rdv_models.Rdv;

public interface RdvService {
	
	//avoir_liste_rdv
	List<Rdv> getIdRdvList();
	
	//enregistrer_une_rdv
	Rdv saveRdv(Rdv rdv);
	
	//trouver_une_rdv
	Rdv findRdvById(Long id);
	
	//màj_une_rdv
	Rdv updateRdv(Long id, Rdv rdv);
	
	//affacer_une_rdv
	void deleteById(Long id);

}
