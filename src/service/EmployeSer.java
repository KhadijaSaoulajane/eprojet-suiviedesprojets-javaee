package service;

import java.io.IOException;

import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.EmployeImpl;
import dao.EquipeImpl;
import dao.ProjetImpl;
import dao.TachesImpl;
import entity.Employe;
import entity.Projet;
import entity.Taches;

@WebServlet("/EmployeSer")
public class EmployeSer extends HttpServlet{

	private static final long serialVersionUID = 1L;
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeImpl emp = new EmployeImpl();
		EquipeImpl eq = new EquipeImpl();
		if (request.getParameter("addEmploye")!=null) {
			
			try {
			Date daten = Date.valueOf(request.getParameter("daten"));
			 String email = request.getParameter("email");
			    Employe ee= emp.getEmpByEmail(email);
			    if(ee!=null) {
			    	request.setAttribute("erreurEmailEmploye",
							  "Cet Email Existe déja");
							  RequestDispatcher rd = request.getRequestDispatcher("AjouterEmploye.jsp");
							  rd.forward(request, response); 
			    }
			    else {
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String pass = request.getParameter("pass");
				String role = request.getParameter("role");
				int equipe = Integer.parseInt(request.getParameter("equipe"));
				Employe e= new Employe(nom,prenom,role,pass,email,daten);
				e.setEquipe(eq.getEquipeById(equipe));
				
				emp.addEmp(e);
				response.sendRedirect("AcceuilAdmin.jsp");
			    }
			}catch(IllegalArgumentException e)
			{
				request.setAttribute("erreurDate",
						  "Veuillez écrire un bon format de date");
						  RequestDispatcher rd = request.getRequestDispatcher("AjouterEmploye.jsp");
						  rd.forward(request, response); 
			}catch(Exception e) {
				request.setAttribute("erreurDate",
						  "Veuillez bien saisir les informations!");
						  RequestDispatcher rd = request.getRequestDispatcher("AjouterEmploye.jsp");
						  rd.forward(request, response); 
			}
			
		}else if (request.getParameter("UpdateEmloye")!=null) {
			int ide = Integer.parseInt(request.getParameter("idemp"));
			String email = request.getParameter("email");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String pass = request.getParameter("pass");
			String role = request.getParameter("role");
			int equipe = Integer.parseInt(request.getParameter("equipe"));
			Employe e= new Employe(nom,prenom,role,pass,email);
			e.setEquipe(eq.getEquipeById(equipe));
			emp.updateEmp(ide,nom,prenom,role,pass, email,eq.getEquipeById(equipe));
			response.sendRedirect("AcceuilAdmin.jsp");
		}else if (request.getParameter("searchTextEmp") != null) {
			String motCle= request.getParameter("searchTextEmp");
			List<Employe> emps = emp.ChercherEmploye(motCle);
			HttpSession session = request.getSession();
			session.setAttribute("employesTrouve",emps);
			response.sendRedirect("listEmployes.jsp");
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			EmployeImpl emp = new EmployeImpl();
			ProjetImpl projets = new ProjetImpl();
			TachesImpl taches = new TachesImpl();
			int id = Integer.parseInt(request.getParameter("ide"));
			List<Projet> pp= (List<Projet>) projets.getAllProjets(id);
			List<Taches> tt = (List<Taches>) taches.getTaches(id);
			Employe e = emp.getEmpById(id);
			//int idAdminCourant = Integer.parseInt(request.getParameter("idCourant"));
		
			//System.out.println("id courant-------- = "+idAdminCourant);
			
			if(pp.isEmpty() & tt.isEmpty()) {
				emp.deleteEmp(e);
				response.sendRedirect("AcceuilAdmin.jsp");
			}
				
			/*
			 * if(id== idAdminCourant) { request.setAttribute("erreurDeleteEmp",
			 * "Vous ne pouvez pas vous supprimez vous même"); RequestDispatcher rd =
			 * request.getRequestDispatcher("AdminIndex.jsp"); rd.forward(request,
			 * response); }
			 */
				 
			
		
		  else { request.setAttribute("erreurDeleteEmp",
		  "L'employé ne doit pas etre affecté à une tache ou projet");
		  RequestDispatcher rd = request.getRequestDispatcher("AcceuilAdmin.jsp");
		  rd.forward(request, response); }
		 
		//}
		 }catch (Exception e) {
			request.setAttribute("erreurDeleteEmp", "Vous ne pouvez pas Supprimer cet employé");
            RequestDispatcher rd = request.getRequestDispatcher("AcceuilAdmin.jsp");
            rd.forward(request, response);    
		}
	}
	
	 public EmployeSer() {
	        super();
	    }
	
	
	
}

