package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.PublicationDao;

@WebServlet("/company/publications/delete")
public class PublicationDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private PublicationDao publicationDao;
  @EJB
  private CompanyDao companyDao;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("company", companyDao.getById(Integer.parseInt(request.getParameter("company_id"))));
    request.setAttribute("publication", publicationDao.getById(Integer.parseInt(request.getParameter("id"))));

    this.getServletContext().getRequestDispatcher("/WEB-INF/company/publications/delete.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    publicationDao.delete(Integer.parseInt(request.getParameter("id")));

    response.sendRedirect("/PapyFinance/company?id=" + Integer.parseInt(request.getParameter("company_id")));
  }
}
