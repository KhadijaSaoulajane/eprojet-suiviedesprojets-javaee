package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.HibernateUtil;
import entity.Employe;
import entity.Projet;
import entity.Taches;

public class TachesImpl implements ITaches {

	private SessionFactory factory = HibernateUtil.getFactory();
	
	
	public void addTache(Taches tache) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(tache);
		session.getTransaction().commit();
		session.close();		
	}

	
	public void deleteTache(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Taches tache = session.get(Taches.class,id);
		session.delete(tache);
		session.getTransaction().commit();
		session.close();		
	}

	
	public Taches getTacheById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Taches tache = session.get(Taches.class,id);
		session.getTransaction().commit();
		session.close();
		return tache;
	}

	
	public List<Taches> getTaches(int idTache, String statut) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Taches> taches = (List<Taches>) session.createQuery("from Taches where id_tache = :idTache and statut_tache like :statutTache")
				.setParameter("idTache",idTache).setParameter("statutTache",statut).list();
		session.getTransaction().commit();
		session.close();
		return taches;
		}

	
	public List<Taches> getTaches(int idEmpl) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Taches> taches = (List<Taches>) session.createQuery("from Taches where id_empl =:idEmpl")
				.setParameter("idEmpl",idEmpl).list();
		session.getTransaction().commit();
		session.close();
		return taches;
	}

	
	public List<Taches> getTaches(Projet projet) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Taches> taches = (List<Taches>)session.createQuery("from Taches where code_pro =:code").setParameter("code",projet.getCodePro()).list();
		session.getTransaction().commit();
		session.close();
		return taches;
	}

	
	public void updateTache(int id, String statut, Date dateDebutTache, Date dateFinTache, int chargeHoraireTache,
			int prioriteTache, Projet projet, String descriptionTache) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Taches tache = new Taches();
		tache = session.get(Taches.class, id);
		tache.setStatutTache(statut);
		tache.setDateDebutTache(dateDebutTache);
		tache.setDateFinTache(dateFinTache);
		tache.setChargeHoraireTache(chargeHoraireTache);
		tache.setDescriptionTache(descriptionTache);
		tache.setPrioriteTache(prioriteTache);
		tache.setProjet(projet);
		session.save(tache);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public void updateTache(int id, String statut, Date dateDebutTache, Date dateFinTache, Employe emp) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Taches tache = new Taches();
		tache = session.get(Taches.class, id);
		tache.setStatutTache(statut);
		tache.setDateDebutTache(dateDebutTache);
		tache.setDateFinTache(dateFinTache);
		tache.setEmploye(emp);
		session.save(tache);
		session.getTransaction().commit();
		session.close();		
	}
	public void updateTache(int id, String statut, String description,int charge, Employe emp) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Taches tache = new Taches();
		tache = session.get(Taches.class, id);
		tache.setStatutTache(statut);
		tache.setChargeHoraireTache(charge);
		tache.setDescriptionTache(description);
		tache.setEmploye(emp);
		session.save(tache);
		session.getTransaction().commit();
		session.close();		
	}

	
	public void updateTache(int id, String statut, Date dateDebutTache, Date dateFinTache) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Taches tache = new Taches();
		tache = session.get(Taches.class, id);
		tache.setStatutTache(statut);
		tache.setDateDebutTache(dateDebutTache);
		tache.setDateFinTache(dateFinTache);
		session.save(tache);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public void affecterTache(Taches tache, Employe empl) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tache.setEmploye(empl);
		session.save(tache);
		session.getTransaction().commit();
		session.close();		
	}


	public List<Taches> getTachesByCode(String code) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Taches> taches = (List<Taches>)session.createQuery("from Taches where code_pro =:code").setParameter("code",code).list();
		session.getTransaction().commit();
		session.close();
		return taches;
	}

}
