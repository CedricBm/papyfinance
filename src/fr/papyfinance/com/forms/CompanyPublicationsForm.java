package fr.papyfinance.com.forms;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.resources.Util;

public class CompanyPublicationsForm {
  private CompanyDao companyDao;

  public CompanyPublicationsForm() {
    companyDao = new CompanyDao();
  }

  public Publication getPublication(HttpServletRequest request) {
    Publication pub = new Publication();

    pub.setTitle(Util.getInputValue(request, "title"));
    pub.setDescription(Util.getInputValue(request, "description"));
    pub.setCompany(companyDao.getById(Integer.parseInt(Util.getInputValue(request, "id_company"))));
    pub.setUser(Util.currentUser(request.getSession()));

    return pub;
  }

  public Publication getPublication(HttpServletRequest request, Publication pub) {
    pub.setTitle(Util.getInputValue(request, "title"));
    pub.setDescription(Util.getInputValue(request, "description"));

    return pub;
  }
}
