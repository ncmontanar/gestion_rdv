package hopital.gestion_rdv_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;



import hopital.gestion_rdv_models.Rdv;
import hopital.gestion_rdv_services.RdvService;


//class
@RestController
@RequestMapping(path = "/api/rdv")
public class RdvController {

	//annotation
	@Autowired 
	private RdvService rdvservice;
	
	//avoir_liste_rdv
	@GetMapping(path = "/")
	public ResponseEntity <List<Rdv>> getIdRdvList(){
		try {
			List<Rdv> listrdvs = rdvservice.getIdRdvList();
			return new ResponseEntity<>(listrdvs, HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//enregistrer_une_rdv
	@PostMapping(path = "/")
	public ResponseEntity<Rdv> saveRdv(@RequestBody Rdv rdv) {
		try {
			return new ResponseEntity<>(rdvservice.saveRdv(rdv),HttpStatus.CREATED);		
		} catch (Exception e) {
		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}
	
	//trouver_une_rdv
	@GetMapping(path = "/{id}")
	public ResponseEntity<Rdv> findRdvById(@PathVariable Long id){
		try {
			Rdv rdv_tr = rdvservice.findRdvById(id);
			if(rdv_tr != null) {
				return new ResponseEntity<>(rdv_tr, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//màj_une_rdv
	@PutMapping(path = "/{id}")
	public ResponseEntity <Rdv> updateRdv(@PathVariable Long id, @RequestBody Rdv rdv){
		try {
			return  new ResponseEntity<Rdv>(rdvservice.updateRdv(id, rdv), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	//affacer_une_rdv
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Long id) {
		rdvservice.deleteById(id);
		}

	
}
