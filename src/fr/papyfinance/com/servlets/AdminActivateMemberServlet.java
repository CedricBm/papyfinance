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
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.resources.Util;

@WebServlet("/admin/activate")
public class AdminActivateMemberServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private UserDao ud;
  @Inject
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.getServletContext().getRequestDispatcher("/WEB-INF/admin/all-company_member.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = ud.getByEmail(util.getInputValue(request, "email"));
    if (u.getLogin() == null && (util.getInputValue(request, "login") == null || util.getInputValue(request, "password") == null)) {
      request.setAttribute("email", u.getEmail());
      this.getServletContext().getRequestDispatcher("/WEB-INF/admin/activate-company_member.jsp").forward(request, response);
    } else {
      u = ud.getByEmail(util.getInputValue(request, "email"));
      if (u.getLogin() == null) {
        u.setLogin(util.getInputValue(request, "login"));
        u.setPassword(util.encrypt(util.getInputValue(request, "password")));
      }
      u.setConfirmed(true);
      if (ud.update(u)) {
        request.getSession().setAttribute("activated", "L'utilisateur " + u.getEmail() + " a bien été activé !");
      } else {
        request.getSession().setAttribute("not_activated", "L'utilisateur " + u.getEmail() + " n'a pas été activé !");
      }
      if (util.getInputValue(request, "role").equals("company-member")) {
        response.sendRedirect("company-members");
      } else {
        response.sendRedirect("investors");
      }

      doGet(request, response);
    }
  }
}
