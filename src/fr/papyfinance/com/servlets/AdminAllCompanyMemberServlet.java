package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;

@WebServlet("/admin/company-members")
public class AdminAllCompanyMemberServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private UserDao ud;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArrayList<User> listeUsers = ud.getAllCompanyMember();
    request.setAttribute("listeUsers", listeUsers);

    this.getServletContext().getRequestDispatcher("/WEB-INF/admin/all-company_member.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}