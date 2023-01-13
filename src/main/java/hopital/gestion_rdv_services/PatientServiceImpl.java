package hopital.gestion_rdv_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import hopital.gestion_rdv_DAO.MedecinDAO;
import hopital.gestion_rdv_DAO.PatientDAO;
//import hopital.gestion_rdv_DAO.RdvDAO;
import hopital.gestion_rdv_models.Patient;

@Service
public class PatientServiceImpl  implements PatientService{
	
	@Autowired
	private PatientDAO patientDao;
//	private MedecinDAO medecinDao;
//	private RdvDAO rdvDao;
	
	
	@Override
	public List<Patient> getPatient() {
		
		List<Patient> ptListe = (List<Patient>) patientDao.findAll();
		if(!ptListe.isEmpty()) {
			return ptListe;
		}
		else {
		return null;
		}

		
		
		
	}

	
	@Override
	public Patient updatePatient(Long id_personne, Patient patient) {
		Optional<Patient> retrievePt = patientDao.findById(id_personne);
		Patient _pt2 = retrievePt.get();
		_pt2.setPrenomPersone(patient.getPrenomPersone());
		patientDao.save(_pt2);
		return _pt2;
	}


	///
	@Override
	public Patient savePatient(Patient patient) {
		return patientDao.save(patient);
	}
	
	///
	@Override
	public void deletePatient(Long id_personne) {
		patientDao.deleteById(id_personne);
		
	}


	@Override
	public Patient findByNom(String nomPersonne) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
