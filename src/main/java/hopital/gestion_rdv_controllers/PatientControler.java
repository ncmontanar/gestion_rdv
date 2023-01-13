package hopital.gestion_rdv_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hopital.gestion_rdv_models.Patient;
import hopital.gestion_rdv_services.PatientService;



@RestController
@RequestMapping(path="/api/patients")
public class PatientControler {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping(path ="/")
	public ResponseEntity<List<Patient>> getPatient() {
		try {
			List<Patient> patients = patientService.getPatient();
			return new ResponseEntity<>(patients, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(path="/{nom}")
	public ResponseEntity<Patient> getPatientByName(@PathVariable String nom) {
		try {
			return new ResponseEntity<>(patientService.findByNom(nom), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping(path="/")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		try {
			return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<Patient>  updatePatient(@PathVariable Long id,@RequestBody Patient patient) {
        try {
            return new ResponseEntity<Patient>(patientService.updatePatient(id, patient), HttpStatus.OK) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@DeleteMapping(path="/{id}")
	public void deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
	}


}
