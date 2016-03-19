package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.SectorDao;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.forms.CompanyForm;
import fr.papyfinance.com.resources.Util;

@WebServlet("/company/new")
public class CompanyNewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private CompanyDao cd;
  private CompanyForm cf;
  private SectorDao sd;
  private UserDao ud;

  public CompanyNewServlet() {
    cd = new CompanyDao();
    cf = new CompanyForm();
    sd = new SectorDao();
    ud = new UserDao();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = Util.currentUser(request.getSession());
    if (u.getCompany().getId() == 1) {
      request.setAttribute("sectors", sd.getAll());
      this.getServletContext().getRequestDispatcher("/WEB-INF/company/new.jsp").forward(request, response);
    } else {
      response.sendRedirect("/PapyFinance/company?id=" + u.getCompany().getId());
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Company c = cf.getCompany(request);
    cd.create(c);

    User u = Util.currentUser(request.getSession());
    u.setCompany(c);
    ud.update(u);

    response.sendRedirect("/PapyFinance/company?id=" + c.getId());
  }
}
