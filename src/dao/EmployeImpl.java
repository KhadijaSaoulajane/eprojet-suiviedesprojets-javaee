package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.HibernateUtil;
import entity.Employe;
import entity.Equipe;

public class EmployeImpl implements IEmploye {
     
	private SessionFactory factory = HibernateUtil.getFactory();

	
	
	public void addEmp(Employe employe) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(employe);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public void deleteEmp(Employe employe) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(employe);
		session.getTransaction().commit();
		session.close();
		
		
	}

	
	public void updateEmp(int idEmp, String nomEmp, String prenomEmp, String roleEmp, String motPasseEmp,
			String emailEmp, Date dateNaissanceEmp, Equipe equipe) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employe employe = session.get(Employe.class, idEmp);
		employe.setNomEmpl(nomEmp);
		employe.setPrenomEmpl(prenomEmp);
		employe.setRoleEmpl(roleEmp);
		employe.setMotPasseEmpl(motPasseEmp);
		employe.setEmailEmpl(emailEmp);
		employe.setDateNaissanceEmpl(dateNaissanceEmp);
		employe.setEquipe(equipe);
		session.getTransaction().commit();
		session.close();
		
		
	}
	public void updateEmp(int idEmp, String nomEmp, String prenomEmp, String roleEmp, String motPasseEmp,
			String emailEmp, Equipe equipe) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employe employe = session.get(Employe.class, idEmp);
		employe.setNomEmpl(nomEmp);
		employe.setPrenomEmpl(prenomEmp);
		employe.setRoleEmpl(roleEmp);
		employe.setMotPasseEmpl(motPasseEmp);
		employe.setEmailEmpl(emailEmp);
		
		employe.setEquipe(equipe);
		session.getTransaction().commit();
		session.close();
		
		
	}
	

	
	public List<Employe> getAllEmp() {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Employe> employes =(List<Employe>)session.createQuery("from Employe").list();
		session.getTransaction().commit();
		session.close();
		return employes;
		
		
	}
	
	public List<Employe> getAllEmpSaufCurrent(int idCurrent) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Employe> employes =(List<Employe>)session.createQuery("from Employe where id_empl not like :this").setParameter("this",idCurrent).list();
		session.getTransaction().commit();
		session.close();
		return employes;
		
		
	}

	
	public List<Employe> getEmp(String nomEmp, String prenomEmp, String emailEmp) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Employe> employes =(List<Employe>)session.createQuery("from Employe where email_empl like :email or nom_empl like :nom or prenom_empl like :prenom")
				.setParameter("email",emailEmp).setParameter("nom",nomEmp)
				.setParameter("prenom",prenomEmp).list();
		session.getTransaction().commit();
		session.close();
		return employes;
		
	}

	
	public Employe getEmpByEmail(String email) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employe employe = (Employe) session.createQuery("from Employe where email_empl like :email")
				.setParameter("email",email).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return employe;
	}

	
	public Employe getEmpById(int id) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employe employe = (Employe) session.createQuery("from Employe where id_empl =:id").setParameter("id",id).getSingleResult();	
		session.getTransaction().commit();
		session.close();
		return employe;
	}
	
	
	public List<Employe> getEmployeByRole() {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Employe> employes = (List<Employe>) session.createQuery("from Employe where role_empl = 'Employe' ").list();
		session.getTransaction().commit();
		session.close();
		return employes;
	}
	
	
	public String getRoleEmploye(String emailEmpl) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String roleEmpl = (String) session.createQuery("select role_empl from Employe where email_empl like :emailEmpl")
				.setParameter("emailEmpl",emailEmpl).getSingleResult();
		session.getTransaction().commit();
		session.close();
		return roleEmpl;
	}
	
	
	public boolean isConnect(String emailEmpl, String motPasseEmpl) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		try {
			
		String motPasse = (String) session.createQuery("select mot_passe_empl from Employe where email_empl like :emailEmpl")
				.setParameter("emailEmpl", emailEmpl)
				.getSingleResult();
		session.getTransaction().commit();
		if (motPasseEmpl.equals(motPasse)) {
			session.close();
			return true;
		} else {
			session.close();
			return false;
		}
		}
		catch( NoResultException n) {
			session.close();

			return false;
		}
		
	}
	
public List<Employe> ChercherEmploye(String motCle) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Employe> employes = (List<Employe>) session.createQuery("from Employe where nom_empl like :nomEmp OR prenom_empl like :nomEmp OR role_empl like :nomEmp ").setParameter("nomEmp","%"+motCle+"%").list();
		session.getTransaction().commit();
		session.close();
		return employes;
	}
	
public List<Employe> ChercherEmployeDuneEquipe(int codeEquipe) {
	
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	List<Employe> employes = (List<Employe>) session.createQuery("from Employe where code_equipe like :codeequipe").setParameter("codeequipe",codeEquipe).list();
	session.getTransaction().commit();
	session.close();
	return employes;
}

	

}
