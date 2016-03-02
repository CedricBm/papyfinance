package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.resources.Util;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	if (Util.currentUser(request.getSession()) == null) {
	//		this.getServletContext().getRequestDispatcher("/WEB-INF/landing/landing.jsp").forward(request, response);
	//	} else if (Util.currentUser(request.getSession()).getRole().getName() == "Administrateur") {
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request,
					response);
	//	} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}