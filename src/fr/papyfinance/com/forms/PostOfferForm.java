package fr.papyfinance.com.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.ContractTypeDao;
import fr.papyfinance.com.dao.NegociationModeDao;
import fr.papyfinance.com.dao.OfferTypeDao;
import fr.papyfinance.com.resources.Util;

@Stateless
public class PostOfferForm {
  @EJB
  private CompanyDao companyDao;
  @EJB
  private OfferTypeDao offerTypeDao;
  @EJB
  private NegociationModeDao negociationModeDao;
  @EJB
  private ContractTypeDao contractTypeDao;
  @Inject
  private Util util;

  public Offer postOffer(HttpServletRequest request) throws ParseException {
    Offer offer = new Offer();
    Auction auction = new Auction();
    String id_company;
    String id_offerType;
    String id_negoMode;
    String id_contratType;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    String odate = util.getInputValue(request, "dateFin");

    offer.setPrice(Float.parseFloat(util.getInputValue(request, "oprice")));
    offer.setQuantity(Float.parseFloat(util.getInputValue(request, "qte")));
    id_company = util.getInputValue(request, "company");

    if (id_company != null) {
      offer.setCompany(companyDao.getById(Integer.parseInt(id_company)));
    } else {
      throw new RuntimeException();
    }

    id_offerType = util.getInputValue(request, "oofferType");
    offer.setOfferType(offerTypeDao.getById(Integer.parseInt(id_offerType)));

    id_negoMode = util.getInputValue(request, "onegociationMode");
    offer.setNegociationMode(negociationModeDao.getById(Integer.parseInt(id_negoMode)));

    id_contratType = util.getInputValue(request, "ocontratType");
    offer.setContractType(contractTypeDao.getById(Integer.parseInt(id_contratType)));

    offer.setValid(true);
    offer.setUser(util.currentUser(request.getSession()));

    if (Integer.parseInt(id_negoMode) == 2) {
      auction.setDateFin(formatter.parse(odate));
      auction.setOffer(offer);
      offer.setAuction(auction);
    }

    return offer;
  }
}
