package dao;

import java.util.List;

import entity.Projet;

public interface IProjet {

	void addProjet(Projet projet);
	
	void deleteProjet(Projet projet);
	
	void updateProjet(String codePro, String nomPro, String descriptionPro, int chargeHorairePro);
	
	List<Projet> findProjet(String codeProjet, String nomProjet,int idEmpl);
	
	List<Projet> getAllProjets(int idChefProjet);
	
	Projet getProjetByCode(String codeProjet);
	
}
