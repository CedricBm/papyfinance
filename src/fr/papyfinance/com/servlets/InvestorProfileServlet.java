package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.TransactionDao;
import fr.papyfinance.com.resources.Util;


@WebServlet("/investor/profile")
public class InvestorProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InvestorProfileServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 OfferDao offerDao = new OfferDao();
		 TransactionDao transactionDao = new TransactionDao();
		 List<Offer> lst = offerDao.getAll();
		 User u = Util.currentUser(request.getSession()); 
		 
		 List<Transaction> trs = transactionDao.getAll();
		 List<Transaction> trb = transactionDao.getAll();

		 Iterator<Offer> iterator = lst.iterator();
		 Iterator<Transaction> it2 = trs.iterator();
		 Iterator<Transaction> it3 = trb.iterator();

		 
		 while ( iterator.hasNext() ) {
		     Offer o = iterator.next();
		     
		     if (o.getUser().getId() != u.getId()) {
		         iterator.remove();
		     }
		 }
		 
		 while ( it2.hasNext() ) {
			 Transaction t = it2.next();
		     
		     if (t.getSeller().getId() != u.getId()) {
		         it2.remove();
		     }
		 }
		
		 while ( it3.hasNext() ) {
			 Transaction t = it3.next();
		     
		     if (t.getBuyer().getId() != u.getId()) {
		         it3.remove();
		     }
		 }

		 request.setAttribute("listeTransactionsAchetees", trs);
		 request.setAttribute("listeTransactionsVendues", trb);
		 request.setAttribute("listeOffers", lst);
		 this.getServletContext().getRequestDispatcher("/WEB-INF/investor/profile.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
