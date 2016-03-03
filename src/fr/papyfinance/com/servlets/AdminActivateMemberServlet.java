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

@WebServlet("/admin/activate")
public class AdminActivateMemberServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	if (Util.currentUser(request.getSession()) == null) {
	//		this.getServletContext().getRequestDispatcher("/WEB-INF/landing/landing.jsp").forward(request, response);
	//	} else if (Util.currentUser(request.getSession()).getRole().getName() == "Administrateur") {
			UserDao ud = new UserDao();
			User u = ud.getByEmail(Util.getInputValue(request, "email"));
			u.setConfirmed(true);
			u.setLogin("test");
			u.setPassword(Util.encrypt("test"));
			ud.update(u);
			response.sendRedirect("/PapyFinance/admin/all/company_member");
		
	//	} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
