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

import hopital.gestion_rdv_models.Medecin;
import hopital.gestion_rdv_services.MedecinService;



@RestController
@RequestMapping(path = "/api/medecins")
public class MedecinController {

	
	@Autowired
	private MedecinService medecinService;
	
	@GetMapping(path ="/")
	public ResponseEntity<List<Medecin>> getMedecins() {
		try {
			List<Medecin> medecins = medecinService.getMedecins();
			return new ResponseEntity<>(medecins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/{nom}")
	public ResponseEntity<Medecin> getMedecinByName(@PathVariable String nom) {
		try {
			return new ResponseEntity<>(medecinService.findByNom(nom), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping(path="/")
	public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin) {
		try {
			return new ResponseEntity<>(medecinService.saveMedecin(medecin), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<Medecin>  updateMedecin(@PathVariable Long id,@RequestBody Medecin medecin) {
        try {
            return new ResponseEntity<Medecin>(medecinService.updateMedecin(id, medecin), HttpStatus.OK) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@DeleteMapping(path="/{id}")
	public void deleteMedecin(@PathVariable Long id) {
		medecinService.deleteMedecin(id);
	}
}
