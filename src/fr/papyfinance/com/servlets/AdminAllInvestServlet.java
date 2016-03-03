package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;

@WebServlet("/admin/all/invest")
public class AdminAllInvestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AdminAllInvestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		UserDao ud = new UserDao();
		ArrayList<User> listeUsers = ud.getAllByRole(3);
		HttpSession session = request.getSession();
		session.setAttribute("_LISTE_USERS",listeUsers);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin/all-invest.jsp").forward(request,
				response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
}