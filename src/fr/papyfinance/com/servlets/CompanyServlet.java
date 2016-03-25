package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.dao.CompanyDao;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private CompanyDao cd;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Company c;
    if (request.getParameter("id") == null) {
      c = cd.getByName("Aucune société");
    } else {
      c = cd.getById(Integer.parseInt(request.getParameter("id")));
    }
    request.setAttribute("company", c);
    if (!c.isConfirmed()) {
      request.setAttribute("alert", "Cette société n'est pas accréditée!");
    }
    this.getServletContext().getRequestDispatcher("/WEB-INF/company/company.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
