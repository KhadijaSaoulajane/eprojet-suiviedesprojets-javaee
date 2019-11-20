package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.HibernateUtil;
import entity.Employe;
import entity.Equipe;

public class EquipeImpl implements IEquipe{
	
	private SessionFactory factory = HibernateUtil.getFactory();

	
	
	public void addEquipe(Equipe equipe) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(equipe);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public void deleteEquipe(Equipe equipe) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(equipe);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public void updateEquipe(int idEquipe, String nomEquipe, String descriptionEquipe) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Equipe equipe = session.get(Equipe.class, idEquipe);
		equipe.setNomEquipe(nomEquipe);
		equipe.setDescriptionEquipe(descriptionEquipe);
		session.save(equipe);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Equipe> getAllEquipes() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Equipe> equipes = (List<Equipe>) session.createQuery("from Equipe").list();
		session.getTransaction().commit();
		session.close();
		return equipes;
	}

	
	public List<Equipe> getEquipe(String nomEquipe) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Equipe> equipes = (List<Equipe>) session.createQuery("from Equipe where nom_equipe like :nom").setParameter("nom",nomEquipe).list();
		session.getTransaction().commit();
		session.close();
		return equipes;	
		}

	
	public Equipe getEquipeById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Equipe equipe = (Equipe) session.createQuery("from Equipe where code_equipe =:id ").setParameter("id", id).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return equipe;	
		}
	
public List<Equipe> ChercherEquipe(String motCle) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Equipe> equipes = (List<Equipe>) session.createQuery("from Equipe where nom_equipe LIKE :nomEq OR description_equipe LIKE :nomEq").setParameter("nomEq","%"+motCle+"%").list();
		session.getTransaction().commit();
		session.close();
		return equipes;
	}
	

}
