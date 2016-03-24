package fr.papyfinance.com.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.ContractTypeDao;
import fr.papyfinance.com.dao.NegociationModeDao;
import fr.papyfinance.com.dao.OfferTypeDao;
import fr.papyfinance.com.resources.Util;

public class PostOfferForm {

  private CompanyDao companyDao;
  private OfferTypeDao offerTypeDao;
  private NegociationModeDao negociationModeDao;
  private ContractTypeDao contractTypeDao;

  public PostOfferForm() {
    companyDao = new CompanyDao();
    offerTypeDao = new OfferTypeDao();
    negociationModeDao = new NegociationModeDao();
    contractTypeDao = new ContractTypeDao();
  }

  public Offer postOffer(HttpServletRequest request) throws ParseException {
    Offer offer = new Offer();
    Auction auction = new Auction();
    String id_company;
    String id_offerType;
    String id_negoMode;
    String id_contratType;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String odate = Util.getInputValue(request, "dateFin");

    offer.setPrice(Float.parseFloat(Util.getInputValue(request, "oprice")));
    offer.setQuantity(Float.parseFloat(Util.getInputValue(request, "qte")));
    id_company = Util.getInputValue(request, "company");

    if (id_company != null) {
      offer.setCompany(companyDao.getById(Integer.parseInt(id_company)));
    } else {
      offer.setCompany(companyDao.getByName("Aucune société"));
    }

    id_offerType = Util.getInputValue(request, "oofferType");
    offer.setOfferType(offerTypeDao.getById(Integer.parseInt(id_offerType)));

    id_negoMode = Util.getInputValue(request, "onegociationMode");
    offer.setNegociationMode(negociationModeDao.getById(Integer.parseInt(id_negoMode)));

    id_contratType = Util.getInputValue(request, "ocontratType");
    offer.setContractType(contractTypeDao.getById(Integer.parseInt(id_contratType)));

    offer.setValid(true);
    offer.setUser(Util.currentUser(request.getSession()));

    if (Integer.parseInt(id_negoMode) == 2) {
      auction.setDateFin(formatter.parse(odate));
      auction.setOffer(offer);
      offer.setAuction(auction);
    }

    return offer;
  }
}
