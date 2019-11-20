package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.HibernateUtil;
import entity.Projet;

public class ProjetImpl implements IProjet {
	private SessionFactory factory = HibernateUtil.getFactory();

	
	public void addProjet(Projet projet) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(projet);
		session.getTransaction().commit();
		session.close();		
	}

	
	public void deleteProjet(Projet projet) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(projet);
		session.getTransaction().commit();
		session.close();		
	}

	
	public void updateProjet(String codeProjet, String nomProjet, String descriptionProjet, int chargeHoraireProjet) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Projet projet = session.get(Projet.class, codeProjet);
		projet.setNomPro(nomProjet);
		projet.setDescriptionPro(descriptionProjet);
		projet.setChargeHorairePro(chargeHoraireProjet);
		session.save(projet);
		session.getTransaction().commit();
		session.close();		
	}

	
	public List<Projet> findProjet(String codeProjet, String nomProjet, int idEmpl) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Projet> projets = (List<Projet>) session.createQuery("from Projet where id_empl =:idEmpl"
				+ " and code_pro like :codeProjet  or nom_pro like :nomProjet  ")
				.setParameter("idEmpl",idEmpl)
				.setParameter("codeProjet",codeProjet)
				.setParameter("nomProjet",nomProjet).list();
		session.getTransaction().commit();
		session.close();
		return projets;
	}

	
	public List<Projet> getAllProjets(int idEmpl) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Projet> projets = (List<Projet>) session
				.createQuery("from Projet where id_empl = :idProjet ")
				.setParameter("idProjet", idEmpl).list();
		session.getTransaction().commit();
		session.close();
		return projets;
	}

	
	public Projet getProjetByCode(String codeProjet) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Projet projet = (Projet) session.createQuery("from Projet where code_pro =:codeProjet")
				.setParameter("codeProjet",codeProjet).getSingleResult();
		session.getTransaction().commit();
		session.close();
		return projet;
	}


	public List<Projet> ChercherProjet(int idEmpl, String motCle) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Projet> projets = (List<Projet>) session
				.createQuery("from Projet where id_empl = :idProjet and nom_pro like :motcle  ")
				.setParameter("idProjet", idEmpl).setParameter("motcle","%"+motCle+"%").list();
		session.getTransaction().commit();
		session.close();
		return projets;
	
	}

}
