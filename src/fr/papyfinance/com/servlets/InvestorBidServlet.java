package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.AuctionOfferDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.resources.Util;


@WebServlet("investor/offers/bid")
public class InvestorBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AuctionOfferDao auctionOfferDao;

    public InvestorBidServlet() {
        super();
        auctionOfferDao = new AuctionOfferDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OfferDao of = new OfferDao();
		List<AuctionOffer> lst = auctionOfferDao.getAll();
		Iterator<AuctionOffer> iterator = lst.iterator();
	    int id =Integer.parseInt(Util.getInputValue(request, "oid"));
		Offer o = of.getById(id);
		 
		 while ( iterator.hasNext() ) {
			 AuctionOffer a = iterator.next();
		     
		     if (a.getAuction().getOffer().getId() != o.getId()) {
		         iterator.remove();
		     }
		 }

		request.setAttribute("listAuctionOffers", lst);
		request.setAttribute("offer", o);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/investor/bidOffer.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
