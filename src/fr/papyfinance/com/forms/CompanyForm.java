package fr.papyfinance.com.forms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.dao.SectorDao;
import fr.papyfinance.com.resources.Util;

@Stateless
public class CompanyForm {
  @EJB
  private SectorDao sectorDao;
  @Inject
  private Util util;

  public Company getCompany(HttpServletRequest request) {
    Company c = new Company();

    c.setName(util.getInputValue(request, "name"));
    c.setRevenue(util.getInputValue(request, "revenue"));
    c.setWebsite(util.getInputValue(request, "website"));
    c.setWorkforce(util.getInputValue(request, "workforce"));
    c.setSector(sectorDao.getById(Integer.parseInt(util.getInputValue(request, "sector"))));

    return c;
  }

  public Company getCompany(HttpServletRequest request, Company c) {
    c.setName(util.getInputValue(request, "name"));
    c.setRevenue(util.getInputValue(request, "revenue"));
    c.setWebsite(util.getInputValue(request, "website"));
    c.setWorkforce(util.getInputValue(request, "workforce"));
    c.setSector(sectorDao.getById(Integer.parseInt(util.getInputValue(request, "sector"))));

    return c;
  }
}
