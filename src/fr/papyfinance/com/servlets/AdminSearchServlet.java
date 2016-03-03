package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.forms.SubscribeForm;
import fr.papyfinance.com.resources.Util;

@WebServlet("/admin/search")
public class AdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SubscribeForm subscribeForm;
	private UserDao userDao;
	
	public AdminSearchServlet() {
		super();
	//	subscribeForm = new SubscribeForm();
	//	userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*if (Util.currentUser(request.getSession()) == null) {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connection/signup.jsp" ).forward( request, response );
		} else {
			request.getSession().setAttribute("already_connected", "Vous �tes d�j� connect�.");
			response.sendRedirect("/PapyFinance");
		}*/
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin/search.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*User u = subscribeForm.getUser(request);

		if (userDao.create(u)) {
			Util.login(u, request.getSession());
			request.getSession().setAttribute("subscribe", "Inscription r�ussie!");
			response.sendRedirect("/PapyFinance");
		} else {
			request.setAttribute("error", "Votre login et/ou votre email n'est pas disponible.");
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connection/signup.jsp" ).forward( request, response );
		}*/
		doGet(request,response);
	}
}