package dao;
import java.util.Date;
import java.util.List;

import entity.Employe;
import entity.Projet;
import entity.Taches;

public interface ITaches {

	void addTache(Taches tache);
	
	void deleteTache(int id);
	
	Taches getTacheById(int id);
	
	List<Taches> getTaches(int idTache, String status);
	
	List<Taches> getTaches(int idEmpl);
	
	List<Taches> getTaches(Projet projet);
	
	List<Taches> getTachesByCode(String code);
	
	void updateTache(int id, String status, Date dateDebutTache,
			Date dateFinTache,int chargeHoraireTache,int prioriteTache,
			Projet projet,String descriptionTache);
	
	void updateTache(int id, String status, Date dateDebutTache,
			Date dateFinTache,Employe emp);
	
	void updateTache(int id, String status, Date dateDebutTache,
			Date dateFinTache);
		
	void affecterTache(Taches tache,Employe empl);
	
	
	
	
	
	
	
	
}
