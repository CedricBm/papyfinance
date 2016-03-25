package fr.papyfinance.com.forms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.resources.Util;

@Stateless
public class CompanyPublicationsForm {
  @EJB
  private CompanyDao companyDao;
  @Inject
  private Util util;

  public Publication getPublication(HttpServletRequest request) {
    Publication pub = new Publication();

    pub.setTitle(util.getInputValue(request, "title"));
    pub.setDescription(util.getInputValue(request, "description"));
    pub.setCompany(companyDao.getById(Integer.parseInt(util.getInputValue(request, "id_company"))));
    pub.setUser(util.currentUser(request.getSession()));

    return pub;
  }

  public Publication getPublication(HttpServletRequest request, Publication pub) {
    pub.setTitle(util.getInputValue(request, "title"));
    pub.setDescription(util.getInputValue(request, "description"));

    return pub;
  }
}
