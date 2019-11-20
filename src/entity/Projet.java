package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import entity.Employe;
import entity.Taches;
@Entity
@Table(name = "Projet")
public class Projet {
    @Id
	@Column(name = "code_pro")
    private String code_pro; 
	
	 @Column(name = "nom_pro")
	    private String nom_pro;
	 
	    @Column(name = "description_pro")
	    private String description_pro;
	    
	    @Column(name = "charge_horaire_pro")
	    private Integer charge_horaire_pro;
	    
	    @ManyToOne
		@JoinColumn(name = "id_empl")
		private Employe employe;
		
	    
//	    @ManyToOne
//	    @JoinColumn(name = "id_chef_projet")
//	    private Employe employe;
//	    
//	    @OneToMany(mappedBy = "projet")
//	    private List<Taches> taches;

		public Projet() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Projet(String codePro, String nomPro, String descriptionPro, Integer chargeHorairePro, Employe employe,
				List<Taches> taches) {
			super();
			this.code_pro = codePro;
			this.nom_pro = nomPro;
			this.description_pro = descriptionPro;
			this.charge_horaire_pro = chargeHorairePro;
			this.employe = employe;
			//this.taches = taches;
		}

		public Projet(String codePro, String nomPro, String descriptionPro, Integer chargeHorairePro, Employe employe) {
			super();
			this.code_pro = codePro;
			this.nom_pro = nomPro;
			this.description_pro = descriptionPro;
			this.charge_horaire_pro = chargeHorairePro;
			this.employe = employe;
		}

		public String getCodePro() {
			return code_pro;
		}

		public void setCodePro(String codePro) {
			this.code_pro = codePro;
		}

		public String getNomPro() {
			return nom_pro;
		}

		public void setNomPro(String nomPro) {
			this.nom_pro = nomPro;
		}

		public String getDescriptionPro() {
			return description_pro;
		}

		public void setDescriptionPro(String descriptionPro) {
			this.description_pro = descriptionPro;
		}

		public Integer getChargeHorairePro() {
			return charge_horaire_pro;
		}

		public void setChargeHorairePro(Integer chargeHorairePro) {
			this.charge_horaire_pro = chargeHorairePro;
		}

		public Employe getEmploye() {
			return employe;
		}

		public void setEmploye(Employe employe) {
			this.employe = employe;
		}

		//public List<Taches> getTaches() {
		//	return taches;
		//}

		//public void setTaches(List<Taches> taches) {
		///	this.taches = taches;
		//}

		public Projet(String codePro, String nomPro, String descriptionPro, Integer chargeHorairePro) {
			super();
			this.code_pro = codePro;
			this.nom_pro = nomPro;
			this.description_pro = descriptionPro;
			this.charge_horaire_pro = chargeHorairePro;
		}

	
	
}
