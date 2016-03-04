package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;

@WebServlet("/admin/investors")
public class AdminAllInvestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AdminAllInvestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		UserDao ud = new UserDao();
		ArrayList<User> listeUsers = ud.getAllByRole(3);
		request.setAttribute("listeUsers",listeUsers);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin/all-invest.jsp").forward(request,
				response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
}