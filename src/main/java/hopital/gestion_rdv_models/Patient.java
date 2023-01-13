package hopital.gestion_rdv_models;




import java.io.Serializable;
import java.util.Collection;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient extends Personne implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idPatient;
	
	@Column(name = "premiere Visite")
	private boolean premiereVisite;
	
	
	
	@OneToMany(mappedBy= "patient", fetch = FetchType.LAZY)
	private Collection<Rdv> rdv;
	
	
	public Patient(long id_personne, String nomPersonne, String prenomPersone, Long idPatient, boolean premiereVisite,
			Collection<Rdv> rdv) {
		super(id_personne, nomPersonne, prenomPersone);
//		this.idPatient = idPatient;
		this.premiereVisite = premiereVisite;
		this.rdv = rdv;
	}


	public Patient() {
	}


	public Collection<Rdv> getRdv() {
		return rdv;
	}


	public void setRdv(Collection<Rdv> rdv) {
		this.rdv = rdv;
	}


//	public Long getIdPatient() {
//		return idPatient;
//	}


	public boolean isPremiereVisite() {
		return premiereVisite;
	}


//	public void setIdPatient(Long idPatient) {
//		this.idPatient = idPatient;
//	}


	public void setPremiereVisite(boolean premiereVisite) {
		this.premiereVisite = premiereVisite;
	}

}
