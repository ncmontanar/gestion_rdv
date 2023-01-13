package hopital.gestion_rdv_models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class Personne   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_personne;
	@Column(name="nom")
	private String nomPersonne;
	@Column(name="prenom")
	private String prenomPersone;
	
	
	public Personne(long id_personne, String nomPersonne, String prenomPersone) {
		this.id_personne = id_personne;
		this.nomPersonne = nomPersonne;
		this.prenomPersone = prenomPersone;
	}


	public Personne() {
	}


	public long getId_personne() {
		return id_personne;
	}


	public String getNomPersonne() {
		return nomPersonne;
	}


	public String getPrenomPersone() {
		return prenomPersone;
	}


	public void setId_personne(long id_personne) {
		this.id_personne = id_personne;
	}


	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}


	public void setPrenomPersone(String prenomPersone) {
		this.prenomPersone = prenomPersone;
	}
	
		

}
