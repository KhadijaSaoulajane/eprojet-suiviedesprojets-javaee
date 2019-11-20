package entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Equipe")
public class Equipe {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "code_equipe")
    private Integer code_equipe;
	
    @Column(name = "nom_equipe")
    private String nom_equipe;
    
    @Column(name = "description_equipe")
    private String description_equipe;
 
	
    public Equipe() {
		super();
	}

	public Equipe(String nomEquipe, String descriptionEquipe, Collection<Employe> employes) {
		super();
		this.nom_equipe = nomEquipe;
		this.description_equipe = descriptionEquipe;
		//this.employes = employes;
	}

	public Integer getCodeEquipe() {
		return code_equipe;
	}

	public void setCodeEquipe(Integer codeEquipe) {
		this.code_equipe = codeEquipe;
	}

	public String getNomEquipe() {
		return nom_equipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nom_equipe = nomEquipe;
	}

	public String getDescriptionEquipe() {
		return description_equipe;
	}

	public void setDescriptionEquipe(String descriptionEquipe) {
		this.description_equipe = descriptionEquipe;
	}

	/*public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}*/

	public Equipe(String nomEquipe, String descriptionEquipe) {
		super();
		this.nom_equipe = nomEquipe;
		this.description_equipe = descriptionEquipe;
	}
	
    

}
