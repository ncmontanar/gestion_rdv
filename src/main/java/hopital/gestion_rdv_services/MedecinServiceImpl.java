package hopital.gestion_rdv_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import hopital.gestion_rdv_DAO.MedecinDAO;
//import hopital.gestion_rdv_DAO.PatientDAO;
//import hopital.gestion_rdv_DAO.RdvDAO;
import hopital.gestion_rdv_models.Medecin;



public class MedecinServiceImpl implements MedecinService {

		@Autowired
		private MedecinDAO medecinDAO;
//		@Autowired
//		private RdvDAO rdvDAO;
//		@Autowired
//		private PatientDAO patientDAO;
		
		@Override
		public Medecin updateMedecin(Long id, Medecin medecin) {
			Optional<Medecin> retrievedMedecin = medecinDAO.findById(id);
			
			Medecin _medecin = retrievedMedecin.get();
			_medecin.setNomPersonne(medecin.getNomPersonne());
			_medecin.setPrenomPersone(medecin.getPrenomPersone());
	
			medecinDAO.save(_medecin);
			return _medecin;
		}
	 
		@Override
		public void deleteMedecin(Long id) {
			medecinDAO.deleteById(id);
			
		}

		@Override
		public Medecin saveMedecin(Medecin medecin) {
		
		
			Medecin _medecin = new Medecin();
			
			_medecin.setNomPersonne(medecin.getNomPersonne());
			_medecin.setPrenomPersone(medecin.getPrenomPersone());

			
			medecinDAO.save(_medecin);
			return _medecin;
		}

		@Override
		public List<Medecin> getMedecins() {
			List<Medecin> MEDECINS = (List<Medecin>)medecinDAO.findAll();
			if(!MEDECINS.isEmpty()) {
				return MEDECINS;
			}
			else {
				return null;
			}
		}

		@Override
		public Medecin findByNom(String nom) {
			// TODO Auto-generated method stub
			return null;
		}

}
