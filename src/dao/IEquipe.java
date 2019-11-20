package dao;

import java.util.List;

import entity.Equipe;

public interface IEquipe {
	
	void addEquipe(Equipe equipe);
	
	void deleteEquipe(Equipe equipe);
	
	void updateEquipe(int idEquipe, String nomEquipe, String descriptionEquipe);
	
	List<Equipe> getAllEquipes();
	
	List<Equipe> getEquipe(String nomEquipe);
	
	Equipe getEquipeById(int id);
	
	
}
