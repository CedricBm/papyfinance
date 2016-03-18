package fr.papyfinance.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.dao.PublicationDao;
import fr.papyfinance.com.forms.CompanyAdsForm;

@WebServlet("/company/companyads")
public class CompanyAdsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	  private CompanyAdsForm companyAdsForm;
	  private PublicationDao publicationDao;

	  public CompanyAdsServlet() {
	    super();
	    companyAdsForm = new CompanyAdsForm();
	    publicationDao = new PublicationDao();
	  }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      this.getServletContext().getRequestDispatcher("/WEB-INF/company/companyads.jsp").forward(request, response);

	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Publication pub = companyAdsForm.getPublication(request);
	    if (publicationDao.create(pub)) {
	        request.getSession().setAttribute("subscribe", "Publication réussie!");
	        response.sendRedirect("/PapyFinance/company/mycompany");
	      } else {
	        request.setAttribute("error", "Erreur");
	        this.getServletContext().getRequestDispatcher("/WEB-INF/company/companyads.jsp").forward(request, response);
	      }
	  }
}
