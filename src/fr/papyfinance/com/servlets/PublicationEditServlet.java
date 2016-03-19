package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.PublicationDao;
import fr.papyfinance.com.forms.CompanyPublicationsForm;

@WebServlet("/company/publications/edit")
public class PublicationEditServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private CompanyPublicationsForm companyPublicationsForm;
  private PublicationDao publicationDao;
  private CompanyDao companyDao;

  public PublicationEditServlet() {
    super();
    companyPublicationsForm = new CompanyPublicationsForm();
    publicationDao = new PublicationDao();
    companyDao = new CompanyDao();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("company", companyDao.getById(Integer.parseInt(request.getParameter("company_id"))));
    request.setAttribute("publication", publicationDao.getById(Integer.parseInt(request.getParameter("id"))));

    this.getServletContext().getRequestDispatcher("/WEB-INF/company/publications/edit.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Publication pub = companyPublicationsForm.getPublication(request, publicationDao.getById(Integer.parseInt(request.getParameter("id"))));
    publicationDao.update(pub);

    response.sendRedirect("/PapyFinance/company?id=" + pub.getCompany().getId());
  }
}
