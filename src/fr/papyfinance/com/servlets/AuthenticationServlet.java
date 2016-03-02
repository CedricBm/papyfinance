package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.forms.AuthenticationForm;
import fr.papyfinance.com.resources.Util;

@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthenticationForm authenticationForm;
       
    public AuthenticationServlet() {
        super();
        authenticationForm = new AuthenticationForm();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Util.currentUser(request.getSession()) == null) {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connection/authentication.jsp" ).forward( request, response );
		} else {
			request.getSession().setAttribute("already_connected", "Vous êtes déjà connecté.");
			response.sendRedirect("/PapyFinance");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = authenticationForm.getUser(request);

		if (u == null) {
			request.setAttribute("error", "Votre login ou mot de passe est erroné.");
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connection/authentication.jsp" ).forward( request, response );
		} else if (!u.isConfirmed()) {
			request.getSession().setAttribute("unconfirmed", "Votre compte est en cours de vérification. Veuillez attendre qu'il soit validé.");
			response.sendRedirect("/PapyFinance");
		} else {
			Util.login(u, request.getSession());
			request.getSession().setAttribute("connection", "Connexion réussie!");
			response.sendRedirect("/PapyFinance");
		}
	}

}
