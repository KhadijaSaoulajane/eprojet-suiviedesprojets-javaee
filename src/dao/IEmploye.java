package dao;

import java.util.Date;
import java.util.List;

import entity.Employe;
import entity.Equipe;

public interface IEmploye {

	void addEmp(Employe employe);
	
	void deleteEmp(Employe employe); 
	
	void updateEmp(int idEmp, String nomEmp, String prenomEmp, String roleEmp,String motPassEmp, String emailEmp, Date dateNaissanceEmp, Equipe equipe ); 
	
	List<Employe> getAllEmp();
	
	List<Employe> getEmp(String nomEmp, String prenomEmp,String emailEmp);
	
	Employe getEmpByEmail(String email);
	
	Employe getEmpById(int id);
	
	public List<Employe> getEmployeByRole();
	
	public String getRoleEmploye(String emailEmpl);
	
	public boolean isConnect(String emailEmpl, String motPasseEmpl);


	
}
