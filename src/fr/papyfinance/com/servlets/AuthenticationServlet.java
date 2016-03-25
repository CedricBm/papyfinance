package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
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

  @EJB
  private AuthenticationForm authenticationForm;
  @Inject
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (util.currentUser(request.getSession()) == null) {
      this.getServletContext().getRequestDispatcher("/WEB-INF/connection/authentication.jsp").forward(request, response);
    } else {
      request.getSession().setAttribute("already_connected", "Vous êtes déjà connecté.");
      response.sendRedirect("/PapyFinance");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = authenticationForm.getUser(request);

    if (u == null) {
      request.setAttribute("error", "Votre login ou mot de passe est erroné.");
      this.getServletContext().getRequestDispatcher("/WEB-INF/connection/authentication.jsp").forward(request, response);
    } else if (!u.isConfirmed() && u.getRole().getName().equals("Membre société")) {
      request.getSession().setAttribute("unconfirmed", "Votre compte est en cours de vérification. Veuillez attendre qu'il soit validé.");
      response.sendRedirect("/PapyFinance");
    } else {
      util.login(u, request.getSession());
      request.getSession().setAttribute("connection", "Connexion réussie!");
      response.sendRedirect("/PapyFinance");
    }
  }
}
