package hopital.gestion_rdv_models;



import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Liste_RDV")
public class Rdv implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRdv;
	
	@Column(name = "Date")
	private String dateRdv;
	
	@ManyToOne
	@JoinColumn(name = "ID_PATIENT", nullable = false)
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="ID_MEDECIN", nullable = false)
	private Medecin medecin;
	
	

	public Rdv(Long idRdv, String dateRdv, Patient patient, Medecin medecin) {
		this.idRdv = idRdv;
		this.dateRdv = dateRdv;
		this.patient = patient;
		this.medecin = medecin;
	}


	public Rdv() {
	}


	public Long getIdRdv() {
		return idRdv;
	}


	public String getDateRdv() {
		return dateRdv;
	}


	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}


	public void setDateRdv(String dateRdv) {
		this.dateRdv = dateRdv;
	}


	public Patient getPatient() {
		return patient;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	
}
