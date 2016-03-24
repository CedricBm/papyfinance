package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.TransactionDao;
import fr.papyfinance.com.forms.SetTransactionForm;
import fr.papyfinance.com.resources.Util;

@WebServlet("investor/offers/buy")
public class InvestorBuyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private SetTransactionForm setTransactionForm;
  private TransactionDao transactionDao;
  private OfferDao of;

  public InvestorBuyServlet() {
    super();
    setTransactionForm = new SetTransactionForm();
    transactionDao = new TransactionDao();
    of = new OfferDao();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.getServletContext().getRequestDispatcher("/WEB-INF/investor/allOffers.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(Util.getInputValue(request, "oid"));
    Offer o = of.getById(id);
    o.setValid(false);

    Transaction transaction = setTransactionForm.setTransaction(request);

    if (transactionDao.create(transaction) && of.update(o)) {
      request.getSession().setAttribute("subscribe", "L'offre a bien été acheté !");
      response.sendRedirect("/PapyFinance/investor/profile");
    } else {
      request.setAttribute("error", "une erreur");
      this.getServletContext().getRequestDispatcher("/WEB-INF/investor/allOffers.jsp").forward(request, response);
    }
    doGet(request, response);
  }

}
