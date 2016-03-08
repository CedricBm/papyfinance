package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.resources.Util;

@WebServlet("/admin/deactivate")
public class AdminDeactivateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/admin/all/company-members.jsp")
				.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		UserDao ud = new UserDao();
		User u = ud.getByEmail(Util.getInputValue(request, "email"));
		u.setConfirmed(false);

		if (ud.update(u)) {
			request.getSession()
					.setAttribute(
							"deactivated",
							"L'utilisateur " + u.getEmail()
									+ " a bien été désactivé !");
		} else {
			request.getSession().setAttribute(
					"not_deactivated",
					"L'utilisateur " + u.getEmail()
							+ " n'a pas été désactivé !");
		}
		if (Util.getInputValue(request, "role").equals("company-member")) {

			response.sendRedirect("company-members");
		} else {
			response.sendRedirect("investors");
		}
	}

}
