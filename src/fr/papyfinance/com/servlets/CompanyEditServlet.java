package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.Sector;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.SectorDao;
import fr.papyfinance.com.forms.CompanyForm;

@WebServlet("/company/edit")
public class CompanyEditServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private CompanyDao cd;
  private SectorDao sd;
  private CompanyForm cf;

  public CompanyEditServlet() {
    cd = new CompanyDao();
    sd = new SectorDao();
    cf = new CompanyForm();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Company c = cd.getById(Integer.parseInt(request.getParameter("id")));
    List<Sector> s = sd.getAll();
    request.setAttribute("company", c);
    request.setAttribute("sectors", s);
    this.getServletContext().getRequestDispatcher("/WEB-INF/company/edit.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Company c = cf.getCompany(request, cd.getById(Integer.parseInt(request.getParameter("id"))));
    cd.update(c);

    response.sendRedirect("../company?id=" + c.getId());
  }
}
