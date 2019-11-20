package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeImpl;
import dao.ProjetImpl;
import dao.TachesImpl;
import entity.Employe;
import entity.Projet;
import entity.Taches;

@WebServlet("/ProjetSer")
public class ProjetSer extends HttpServlet {
		private static final long serialVersionUID = 1L;
	 

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			try {
				ProjetImpl projet = new ProjetImpl();
				TachesImpl taches = new TachesImpl();
				String codeProjet = request.getParameter("id");

				List<Taches> tt = (List<Taches>) taches.getTachesByCode(codeProjet);
				Projet projetCourant = projet.getProjetByCode(codeProjet);
				
				if(tt.isEmpty()) {
					projet.deleteProjet(projetCourant);
					response.sendRedirect("AcceuilChefProjet.jsp");
				}
				
			  else { request.setAttribute("erreurDeleteProjet",
			  "Vous ne pouvez pas supprimer un projet qui contient des tâches!");
			  RequestDispatcher rd = request.getRequestDispatcher("AcceuilChefProjet.jsp");
			  rd.forward(request, response); 
			  }
			
		}catch(Exception e) {
			request.setAttribute("erreurDeleteProjet",
					  "Vous ne pouvez pas supprimer ce projet!");
					  RequestDispatcher rd = request.getRequestDispatcher("AcceuilChefProjet.jsp");
					  rd.forward(request, response);
					  }
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if (request.getParameter("updateP")!=null) {
				ProjetImpl p = new ProjetImpl();
				String code=request.getParameter("code");
				int charge = Integer.parseInt(request.getParameter("chargeH"));
				String desc = request.getParameter("description");
				String nom = request.getParameter("nom");
				System.out.println(nom);
				p.updateProjet(code, nom, desc, charge);
				response.sendRedirect("AcceuilChefProjet.jsp");
			}
			if (request.getParameter("addP")!=null) {
				HttpSession session = request.getSession();
				ProjetImpl projet = new ProjetImpl();
				EmployeImpl emp = new EmployeImpl();
				String code=request.getParameter("code");
				int charge = Integer.parseInt(request.getParameter("charge"));
				String desc = request.getParameter("description");
				String nom = request.getParameter("nom");
				Projet p = new Projet(code, nom, desc, charge);
				p.setEmploye(emp.getEmpByEmail((String) session.getAttribute("email")));
				projet.addProjet(p);
				response.sendRedirect("AcceuilChefProjet.jsp");
			}
				else if (request.getParameter("searchTextProjet") != null) {
					HttpSession session = request.getSession();

					ProjetImpl p = new ProjetImpl();
					EmployeImpl emp = new EmployeImpl();

					Employe chef = (Employe) emp.getEmpByEmail((String) session.getAttribute("email"));

					String motCle= request.getParameter("searchTextProjet");
					List<Projet> projets = p.ChercherProjet(chef.getIdEmpl(), motCle);
					
					session.setAttribute("ProjetTrouve",projets);
					response.sendRedirect("listProjets.jsp");
				}
		}
		
	    public ProjetSer() {
	        super();
	    }
	
	
}
