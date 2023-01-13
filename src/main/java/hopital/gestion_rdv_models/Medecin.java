package hopital.gestion_rdv_models;


import java.io.Serializable;
import java.util.Collection;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "medecin")
public class Medecin extends Personne implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedecin;
	@Column(name = "specialite")
	private String specialiteMedecin;
	
	@OneToMany(mappedBy= "medecin", fetch = FetchType.LAZY)
	private Collection<Rdv> rdv;
	


	public Medecin(long id_personne, String nomPersonne, String prenomPersone, long idMedecin, String specialiteMedecin,
			Collection<Rdv> rdv) {
		super(id_personne, nomPersonne, prenomPersone);
		this.idMedecin = idMedecin;
		this.specialiteMedecin = specialiteMedecin;
		this.rdv = rdv;
	}


	public Medecin() {
	}


	
	public Collection<Rdv> getRdv() {
		return rdv;
	}

	public void setRdv(Collection<Rdv> rdv) {
		this.rdv = rdv;
	}

	
	public long getIdMedecin() {
		return idMedecin;
	}

	public String getSpecialiteMedecin() {
		return specialiteMedecin;
	}

	public void setIdMedecin(long idMedecin) {
		this.idMedecin = idMedecin;
	}

	public void setSpecialiteMedecin(String specialiteMedecin) {
		this.specialiteMedecin = specialiteMedecin;
	}


}
