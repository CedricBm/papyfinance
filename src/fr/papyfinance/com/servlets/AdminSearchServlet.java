package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.inject.Inject;
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

  @EJB
  private CompanyDao cd;
  @EJB
  private UserDao ud;
  @EJB
  private OfferDao od;
  @EJB
  private TransactionDao td;
  @Inject
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    switch (Integer.parseInt(util.getInputValue(request, "typeSearch"))) {
      case 1:
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/search-companies.jsp").forward(request, response);
        break;
      case 2:
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/search-users.jsp").forward(request, response);
        break;
      case 3:
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/search-offers.jsp").forward(request, response);
        break;
      case 4:
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/search-transactions.jsp").forward(request, response);
        break;
      default:
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/search-error.jsp").forward(request, response);
    }
  }

  @SuppressWarnings("rawtypes")
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArrayList res = new ArrayList();

    switch (Integer.parseInt(util.getInputValue(request, "typeSearch"))) {
      case 1:
        if (util.getInputValue(request, "search") == null) {
          res = (ArrayList<Company>) cd.getAll();
        } else {
          res = (ArrayList<Company>) cd.getAllWithAttribute(util.getInputValue(request, "search"));
        }
        break;
      case 2:
        if (util.getInputValue(request, "search") == null) {
          res = (ArrayList<User>) ud.getAll();
        } else {
          res = (ArrayList<User>) ud.getAllWithAttribute(util.getInputValue(request, "search"));
        }
        break;
      case 3:
        if (util.getInputValue(request, "search") == null) {
          res = (ArrayList<Offer>) od.getAll();
        } else {
          res = (ArrayList<Offer>) od.getAllWithAttribute(util.getInputValue(request, "search"));
        }
        break;
      case 4:
        if (util.getInputValue(request, "search") == null) {
          res = (ArrayList<Transaction>) td.getAll();
        } else {
          res = (ArrayList<Transaction>) td.getAllWithAttribute(util.getInputValue(request, "search"));
        }
        break;
      default:
    }
    request.setAttribute("listeRes", res);
    doGet(request, response);
  }
}