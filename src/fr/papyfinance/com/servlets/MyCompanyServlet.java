package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.PublicationDao;
import fr.papyfinance.com.dao.UserDao;

@WebServlet("/company/mycompany")
public class MyCompanyServlet extends HttpServlet{

	  private static final long serialVersionUID = 1L;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PublicationDao pd = new PublicationDao();
		  ArrayList<Publication> listePublication = pd.getAllPublication();
		    request.setAttribute("listePublication", listePublication);
		  this.getServletContext().getRequestDispatcher("/WEB-INF/company/mycompany.jsp").forward(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	  }
}
