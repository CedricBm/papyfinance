package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.PublicationDao;
import fr.papyfinance.com.forms.CompanyPublicationsForm;

@WebServlet("/company/publications/new")
public class PublicationNewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private CompanyPublicationsForm companyPublicationsForm;
  @EJB
  private PublicationDao publicationDao;
  @EJB
  private CompanyDao companyDao;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("company", companyDao.getById(Integer.parseInt(request.getParameter("id"))));
    this.getServletContext().getRequestDispatcher("/WEB-INF/company/publications/new.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Publication pub = companyPublicationsForm.getPublication(request);
    publicationDao.create(pub);
    response.sendRedirect("/PapyFinance/company?id=" + pub.getCompany().getId());
  }
}
