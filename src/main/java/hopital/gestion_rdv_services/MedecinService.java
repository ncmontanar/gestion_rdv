package hopital.gestion_rdv_services;

import java.util.List;

import hopital.gestion_rdv_models.Medecin;


public interface MedecinService {
	

	List<Medecin> getMedecins();
	
	Medecin findByNom(String nom);
	
	Medecin saveMedecin(Medecin medecin);
	
	Medecin updateMedecin(Long id, Medecin medecin);
	
	void deleteMedecin(Long id);
	
	

}
