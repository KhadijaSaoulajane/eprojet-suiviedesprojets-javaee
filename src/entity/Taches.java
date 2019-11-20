package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import entity.Employe;
import entity.Projet;


@Entity
@Table(name="Taches")
public class Taches {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tache")
	
    private Integer id_tache;
	
	@Column(name = "description_tache")
    private String description_tache;
	
    @Column(name = "charge_horaire_tache")
    private int charge_horaire_tache;
    
    @Column(name = "priorite_tache")
    private int priorite_tache;
    
    @Column(name = "statut_tache")
    private String statut_tache;
    
    @Column(name = "date_debut_tache")
    private Date date_debut_tache;
    
    @Column(name = "date_fin_tache")
    private Date date_fin_tache;
    
    @ManyToOne
	@JoinColumn(name = "id_empl")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name = "code_pro") 
	private Projet projet;
    
//    @ManyToOne
//    @JoinColumn(name = "code_pro")
//    private Projet projet;
//    
//    @ManyToOne
//    @JoinColumn(name = "id_empl")
//    private Employe employe;

	public Taches() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Taches(String descriptionTache, int chargeHoraireTache, int prioriteTache, String statutTache,
			Date dateDebutTache, Date dateFinTache, Projet projet, Employe employe) {
		super();
		this.description_tache = descriptionTache;
		this.charge_horaire_tache = chargeHoraireTache;
		this.priorite_tache = prioriteTache;
		this.statut_tache = statutTache;
		this.date_debut_tache = dateDebutTache;
		this.date_fin_tache = dateFinTache;
		this.projet = projet;
		this.employe = employe;
	}

	public Integer getIdTache() {
		return id_tache;
	}

	public void setIdTache(Integer idTache) {
		this.id_tache = idTache;
	}

	public String getDescriptionTache() {
		return description_tache;
	}

	public void setDescriptionTache(String descriptionTache) {
		this.description_tache = descriptionTache;
	}

	public int getChargeHoraireTache() {
		return charge_horaire_tache;
	}

	public void setChargeHoraireTache(int chargeHoraireTache) {
		this.charge_horaire_tache = chargeHoraireTache;
	}

	public int getPrioriteTache() {
		return priorite_tache;
	}

	public void setPrioriteTache(int prioriteTache) {
		this.priorite_tache = prioriteTache;
	}

	public String getStatutTache() {
		return statut_tache;
	}

	public void setStatutTache(String statutTache) {
		this.statut_tache = statutTache;
	}

	public Date getDateDebutTache() {
		return date_debut_tache;
	}

	public void setDateDebutTache(Date dateDebutTache) {
		this.date_debut_tache = dateDebutTache;
	}

	public Date getDateFinTache() {
		return date_fin_tache;
	}

	public void setDateFinTache(Date dateFinTache) {
		this.date_fin_tache = dateFinTache;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Taches [idTache=" + id_tache + ", descriptionTache=" + description_tache + ", chargeHoraireTache="
				+ charge_horaire_tache + ", prioriteTache=" + priorite_tache + ", statutTache=" + statut_tache
				+ ", dateDebutTache=" + date_debut_tache + ", dateFinTache=" + date_fin_tache + ", projet=" + projet
				+ ", employe=" + employe + "]";
	}

	public Taches(String descriptionTache, int chargeHoraireTache, int prioriteTache, String statutTache,
			Date dateDebutTache, Date dateFinTache) {
		super();
		this.description_tache = descriptionTache;
		this.charge_horaire_tache = chargeHoraireTache;
		this.priorite_tache = prioriteTache;
		this.statut_tache = statutTache;
		this.date_debut_tache = dateDebutTache;
		this.date_fin_tache = dateFinTache;
	}
	
	
	
	
}
