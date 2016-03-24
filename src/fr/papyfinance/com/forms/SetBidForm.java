package fr.papyfinance.com.forms;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.AuctionDao;
import fr.papyfinance.com.resources.Util;

public class SetBidForm {
	
	private AuctionDao auctionDao;
	
	public SetBidForm() {
		auctionDao = new AuctionDao();
	}




	public AuctionOffer setBid(HttpServletRequest request){
		AuctionOffer ao = new AuctionOffer();
		User b = Util.currentUser(request.getSession());
		int id_offer = Integer.parseInt(Util.getInputValue(request, "oid"));
		double mte = Double.parseDouble(Util.getInputValue(request, "price"));
		
		System.out.println(mte);
		System.out.println(Util.getInputValue(request, "price"));
		System.out.println("==================================================================");
		
		Auction a = auctionDao.getById(id_offer);
		ao.setAuction(a);
		ao.setUser(b);
		ao.setAmount(mte);
		
		return ao;
	}

}
