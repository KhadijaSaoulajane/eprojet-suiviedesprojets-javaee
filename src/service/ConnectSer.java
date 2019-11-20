package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeImpl;
import entity.Employe;

@WebServlet("/ConnectSer")
public class ConnectSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmployeImpl employe = new EmployeImpl();

		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String role;
		if (employe.isConnect(email, pass)) {
			role = employe.getRoleEmploye(email);
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("role", role);
			Employe emp =  employe.getEmpByEmail(email);
			session.setAttribute("id",emp.getIdEmpl());
			session.setAttribute("nom",emp.getNomEmpl());
			session.setAttribute("prenom",emp.getPrenomEmpl());
			session.setAttribute("e", emp);
			if (role.equals("Employe")) {
				response.sendRedirect("AcceuilEmploye.jsp");
			} else if (role.equals("Administrateur")) {
				response.sendRedirect("AcceuilAdminMain.jsp");
			} else if (role.equals("Chef de projet")) {
				response.sendRedirect("AcceuilChefProjet.jsp");
			}
		}else{
			
			
            request.setAttribute("erreurLogin", "Email ou Mot de passe incorrect!");
            RequestDispatcher rd = request.getRequestDispatcher("SeConnecter.jsp");
            rd.forward(request, response);          

			
		}

	}
	public ConnectSer() {
		super();
	}



}
