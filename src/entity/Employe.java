package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import entity.Equipe;
import entity.Projet;
import entity.Taches;

@Entity
@Table(name = "Employe")
public class Employe  {
        @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)

    	@Column(name = "id_empl")
	    private Integer id_empl;
	
	    @Column(name = "nom_empl")
	    private String nom_empl;
	    
	    @Column(name = "prenom_empl")
	    private String prenom_empl;
	    
	    @Column(name = "role_empl")
	    private String role_empl;
	   
	    @Column(name = "mot_passe_empl")
	    private String mot_passe_empl;
	    
	    @Column(name = "email_empl")
	    private String email_empl;
	    
	    @Column(name = "date_naissance_empl")
	    private Date date_naissance_empl;

	    
	    @ManyToOne
		@JoinColumn(name = "code_equipe")
		private Equipe equipe;
	    
	    
		public Employe(String nomEmpl, String prenomEmpl, String roleEmpl, String motPasseEmpl, String emailEmpl,
				Date dateNaissanceEmpl, List<Projet> projets, List<Taches> taches, Equipe equipe) {
			super();
			this.nom_empl = nomEmpl;
			this.prenom_empl = prenomEmpl;
			this.role_empl = roleEmpl;
			this.mot_passe_empl = motPasseEmpl;
			this.email_empl = emailEmpl;
			this.date_naissance_empl = dateNaissanceEmpl;
			this.equipe = equipe;
		}

		public int getIdEmpl() {
			return id_empl;
		}

		public void setIdEmpl(int idEmpl) {
			this.id_empl = idEmpl;
		}

		public String getNomEmpl() {
			return nom_empl;
		}

		public void setNomEmpl(String nomEmpl) {
			this.nom_empl = nomEmpl;
		}

		public String getPrenomEmpl() {
			return prenom_empl;
		}

		public void setPrenomEmpl(String prenomEmpl) {
			this.prenom_empl = prenomEmpl;
		}

		public String getRoleEmpl() {
			return role_empl;
		}

		public void setRoleEmpl(String roleEmpl) {
			this.role_empl = roleEmpl;
		}

		public String getMotPasseEmpl() {
			return mot_passe_empl;
		}

		public void setMotPasseEmpl(String motPasseEmpl) {
			this.mot_passe_empl = motPasseEmpl;
		}

		public String getEmailEmpl() {
			return email_empl;
		}

		public void setEmailEmpl(String emailEmpl) {
			this.email_empl = emailEmpl;
		}

		public Date getDateNaissanceEmpl() {
			return date_naissance_empl;
		}

		public void setDateNaissanceEmpl(Date dateNaissanceEmpl) {
			this.date_naissance_empl = dateNaissanceEmpl;
		}


		public Equipe getEquipe() {
			return equipe;
		}

		public void setEquipe(Equipe equipe) {
			this.equipe = equipe;
		}

		public Employe(String nomEmpl, String prenomEmpl, String roleEmpl, String motPasseEmpl,
				String emailEmpl, Date dateNaissanceEmpl, Equipe equipe) {
			super();
			
			this.nom_empl = nomEmpl;
			this.prenom_empl = prenomEmpl;
			this.role_empl = roleEmpl;
			this.mot_passe_empl = motPasseEmpl;
			this.email_empl = emailEmpl;
			this.date_naissance_empl = dateNaissanceEmpl;
			this.equipe = equipe;
		}

		public Employe() {
			super();
		}

		public Employe(String nomEmpl, String prenomEmpl, String roleEmpl, String motPasseEmpl, String emailEmpl,
				Date dateNaissanceEmpl) {
			super();
			this.nom_empl = nomEmpl;
			this.prenom_empl = prenomEmpl;
			this.role_empl = roleEmpl;
			this.mot_passe_empl = motPasseEmpl;
			this.email_empl = emailEmpl;
			this.date_naissance_empl = dateNaissanceEmpl;
		}

		public Employe(String nom_empl, String prenom_empl, String role_empl, String mot_passe_empl,
				String email_empl) {
			super();
			this.nom_empl = nom_empl;
			this.prenom_empl = prenom_empl;
			this.role_empl = role_empl;
			this.mot_passe_empl = mot_passe_empl;
			this.email_empl = email_empl;
		}

		
	
	
}
