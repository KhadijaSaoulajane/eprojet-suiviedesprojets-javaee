package service;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
import entity.Taches;

@WebServlet("/TachesSer")
public class TachesSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TachesSer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("idtach") != null) {
			TachesImpl tache = new TachesImpl();

			tache.deleteTache(Integer.parseInt(request.getParameter("idtach")));
			response.sendRedirect("AcceuilChefProjet.jsp");

		} else
			doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		//String hada = request.getParameter("hada");
		//String hada2 = request.getParameter("hada2");

		if (request.getParameter("updateT") != null) {

			try {
				EmployeImpl emp = new EmployeImpl();
				TachesImpl tache = new TachesImpl();
				int tacheId = Integer.parseInt(request.getParameter("id"));
                session.setAttribute("idTache", tacheId);
				String description = request.getParameter("descriptionn");

				int charge = Integer.parseInt(request.getParameter("chargeHoraire"));
				String status = request.getParameter("status");

				int idEmpl = Integer.parseInt(request.getParameter("employeId"));

				Employe e = emp.getEmpById(idEmpl);
				tache.updateTache(tacheId,status,description,charge, e);
				response.sendRedirect("AcceuilChefProjet.jsp");
			}  catch (Exception e) {
				request.setAttribute("erreurTache", "Veuillez bien saisir les informations de la tache!");
                 RequestDispatcher rd = request.getRequestDispatcher("AcceuilChefProjet.jsp");
				rd.forward(request, response);
			}

		} else

		if (request.getParameter("addP") != null) {
			try {
				TachesImpl tache = new TachesImpl();
				EmployeImpl emp = new EmployeImpl();
				ProjetImpl p = new ProjetImpl();
				String codep = request.getParameter("codep");
				int charge = Integer.parseInt(request.getParameter("charge"));
				Date dateDebutTache = Date.valueOf(request.getParameter("datedebut"));
				Date dateFinTache = Date.valueOf(request.getParameter("datefin"));
				String description = request.getParameter("description");
				String status = request.getParameter("status");
				int priorite = Integer.parseInt(request.getParameter("priorite"));
				Employe e = emp.getEmpById(Integer.parseInt(request.getParameter("employeId")));

				System.out.println(dateDebutTache);

				Taches t = new Taches(description, charge, priorite, status, dateDebutTache, dateFinTache);
				t.setEmploye(e);
				t.setProjet(p.getProjetByCode(codep));
				tache.addTache(t);

				response.sendRedirect("AcceuilChefProjet.jsp");

			} catch (IllegalArgumentException e) {
				request.setAttribute("erreurDateProjet", "Veuillez écrire un bon format de date pour ajouter projet");
				RequestDispatcher rd = request.getRequestDispatcher("AcceuilChefProjet.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("erreurDateProjet", "Veuillez bien saisir les informations!");
				RequestDispatcher rd = request.getRequestDispatcher("AcceuilChefProjet.jsp");
				rd.forward(request, response);
			}
		}

	}
}
