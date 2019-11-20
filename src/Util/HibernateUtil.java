package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employe;
import entity.Equipe;
import entity.Projet;
import entity.Taches;

public class HibernateUtil {
	
	private static SessionFactory factory=null;
	public static SessionFactory getFactory() {
		if (factory == null) {
			factory = new Configuration().configure()
					.addAnnotatedClass(Employe.class)
					.addAnnotatedClass(Equipe.class)
					.addAnnotatedClass(Projet.class)
					.addAnnotatedClass(Taches.class).buildSessionFactory();
			return factory;
		}else{
			return factory;
		}
	}
}
