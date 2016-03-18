package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.dao.TransactionDao;
import fr.papyfinance.com.resources.Util;

@WebServlet("/investor/search/transactions")
public class InvestorSearchTransactionServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public InvestorSearchTransactionServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      TransactionDao td = new TransactionDao();
      String buyerName = Util.getInputValue(request, "buyerName");
      String sellerName = Util.getInputValue(request, "sellerName");
      String companyName = Util.getInputValue(request, "companyName");
      String i = Util.getInputValue(request, "idOffer");
      int idOffer = -1;
      if (buyerName == null) {
        buyerName = "";
      }
      if (sellerName == null) {
        sellerName = "";
      }
      if (companyName == null) {
        companyName = "";
      }
      if (i != null) {
        idOffer = Integer.parseInt(i);
      }

      ArrayList<Transaction> res = (ArrayList<Transaction>) td.getAllForInvestor(buyerName, sellerName, companyName, idOffer);

      request.setAttribute("listeRes", res);
    } catch (Exception e) {
      request.setAttribute("listeRes", null);
    } finally {
      this.getServletContext().getRequestDispatcher("/WEB-INF/investor/search-transactions.jsp").forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
