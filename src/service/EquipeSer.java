package service;

import java.io.IOException;
import java.io.PrintWriter;
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
import entity.Equipe;
import entity.Projet;
import entity.Taches;

@WebServlet("/EquipeSer")
public class EquipeSer extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    public EquipeSer() {
	        super();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			try {
				EmployeImpl emp = new EmployeImpl();
				int codeEquipe = Integer.parseInt(request.getParameter("codeE"));
				EquipeImpl eq = new EquipeImpl();
				Equipe e = eq.getEquipeById(codeEquipe);
				List<Employe> employesEquipe = (List<Employe>) emp.ChercherEmployeDuneEquipe(codeEquipe);
		     if(employesEquipe.isEmpty()) {
		    	 eq.deleteEquipe(e);
					response.sendRedirect("AcceuilAdmin2.jsp");
				}
			   else { request.setAttribute("erreurDeleteEquipe",
			  "Vous ne pouvez pas supprimer une équipe qui contient des employés!");
			  RequestDispatcher rd = request.getRequestDispatcher("AcceuilAdmin2.jsp");
			  rd.forward(request, response); }
			 
			
			 }catch (Exception e) {
				request.setAttribute("erreurDeleteEquipe", "Vous ne pouvez pas Supprimer cette équipe!");
	            RequestDispatcher rd = request.getRequestDispatcher("AcceuilAdmin2.jsp");
	            rd.forward(request, response);    
			}
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			EquipeImpl eq = new EquipeImpl();
			if (request.getParameter("addE") != null) {
				
				String desc = request.getParameter("desc");
				String nom = request.getParameter("nom");
				
				eq.addEquipe(new Equipe(nom,desc));
				response.sendRedirect("AcceuilAdmin2.jsp");
				
				
			}else if (request.getParameter("updateE") != null) {
				int codeE = Integer.parseInt(request.getParameter("codeEquipe"));
				String desc = request.getParameter("desc");
				String nom = request.getParameter("nom");
				
				eq.updateEquipe(codeE,nom,desc);

				response.sendRedirect("AcceuilAdmin2.jsp");
				
			}else if (request.getParameter("searchTextEq") != null) {
				String motCle= request.getParameter("searchTextEq");
				List<Equipe> equipes = eq.ChercherEquipe(motCle);
				HttpSession session = request.getSession();
				session.setAttribute("equipeTrouve",equipes);
				response.sendRedirect("listEquipes.jsp");
			}
		}

}
