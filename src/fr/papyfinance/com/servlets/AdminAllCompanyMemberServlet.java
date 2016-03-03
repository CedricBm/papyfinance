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
import fr.papyfinance.com.forms.SubscribeForm;

@WebServlet("/admin/all/company_member")
public class AdminAllCompanyMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SubscribeForm subscribeForm;
	private UserDao userDao;
	
	public AdminAllCompanyMemberServlet() {
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
		UserDao ud = new UserDao();
		ArrayList<User> listeUsers = ud.getAllByRole(2);
		HttpSession session = request.getSession();
		session.setAttribute("_LISTE_USERS",listeUsers);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin/all-company_member.jsp").forward(request,
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