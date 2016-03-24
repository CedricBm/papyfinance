package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.OfferDao;



@WebServlet("/investor/offers")
public class InvestorAllOffers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InvestorAllOffers() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 OfferDao offerDao = new OfferDao();
		 List<Offer> ls = offerDao.getAll();
		 request.setAttribute("listeOffers", ls);
		 this.getServletContext().getRequestDispatcher("/WEB-INF/investor/allOffers.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
