package hopital.gestion_rdv_services;

import java.util.List;

import hopital.gestion_rdv_models.Patient;


public interface PatientService {

	
	List<Patient> getPatient();

	Patient findByNom(String nomPersonne);
		
	Patient updatePatient(Long id_personne, Patient patient);
	
	Patient savePatient(Patient patient);
	
	void deletePatient(Long id_personne);
}
