package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.TransactionDao;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.resources.Util;

@WebServlet("/admin/search")
public class AdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		switch (Integer.parseInt(Util.getInputValue(request, "typeSearch"))) {
		case 1:
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/admin/search-companies.jsp")
					.forward(request, response);
			break;
		case 2:
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/admin/search-users.jsp")
					.forward(request, response);
			break;
		case 3:
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/admin/search-offers.jsp")
					.forward(request, response);
			break;
		case 4:
			this.getServletContext()
					.getRequestDispatcher(
							"/WEB-INF/admin/search-transactions.jsp")
					.forward(request, response);
			break;
		default:
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/admin/search-error.jsp")
					.forward(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList res = new ArrayList();

		switch (Integer.parseInt(Util.getInputValue(request, "typeSearch"))) {
		case 1:
			CompanyDao cd = new CompanyDao();
			if (Util.getInputValue(request, "search") == null)
				res = (ArrayList<Company>) cd.getAll();
			else
				res = (ArrayList<Company>) cd.getAllWithAttribute(Util
						.getInputValue(request, "search"));
			break;
		case 2:
			UserDao ud = new UserDao();
			if (Util.getInputValue(request, "search") == null)
				res = (ArrayList<User>) ud.getAll();
			else
				res = (ArrayList<User>) ud.getAllWithAttribute(Util
						.getInputValue(request, "search"));
			break;
		case 3:
			OfferDao od = new OfferDao();
			if (Util.getInputValue(request, "search") == null)
				res = (ArrayList<Offer>) od.getAll();
			else
				res = (ArrayList<Offer>) od.getAllWithAttribute(Util
						.getInputValue(request, "search"));
			break;
		case 4:
			TransactionDao td = new TransactionDao();
			if (Util.getInputValue(request, "search") == null)
				res = (ArrayList<Transaction>) td.getAll();
			else
				res = (ArrayList<Transaction>) td.getAllWithAttribute(Util
						.getInputValue(request, "search"));
			break;
		default:
			break;
		}
		request.setAttribute("listeRes", res);
		doGet(request, response);
	}
}