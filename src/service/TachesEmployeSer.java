package service;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TachesImpl;


@WebServlet("/TachesEmployeSer")
public class TachesEmployeSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public TachesEmployeSer() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		TachesImpl tache = new TachesImpl();
		int tacheId = Integer.parseInt(request.getParameter("id"));
		System.out.println(tacheId);
		session.setAttribute("idTache", tacheId);

		Date dateDebutTache = Date.valueOf(request.getParameter("dateDebut"));
		Date dateFinTache = Date.valueOf(request.getParameter("dateFin"));
		String status = request.getParameter("status");
		
		tache.updateTache(tacheId, status, dateDebutTache, dateFinTache);

		response.sendRedirect("AcceuilEmploye.jsp");
	}


}
