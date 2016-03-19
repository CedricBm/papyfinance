package fr.papyfinance.com.forms;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.dao.SectorDao;
import fr.papyfinance.com.resources.Util;

public class CompanyForm {
  private SectorDao sectorDao;

  public CompanyForm() {
    sectorDao = new SectorDao();
  }

  public Company getCompany(HttpServletRequest request) {
    Company c = new Company();

    c.setName(Util.getInputValue(request, "name"));
    c.setRevenue(Util.getInputValue(request, "revenue"));
    c.setWebsite(Util.getInputValue(request, "website"));
    c.setWorkforce(Util.getInputValue(request, "workforce"));
    c.setSector(sectorDao.getById(Integer.parseInt(Util.getInputValue(request, "sector"))));

    return c;
  }

  public Company getCompany(HttpServletRequest request, Company c) {
    c.setName(Util.getInputValue(request, "name"));
    c.setRevenue(Util.getInputValue(request, "revenue"));
    c.setWebsite(Util.getInputValue(request, "website"));
    c.setWorkforce(Util.getInputValue(request, "workforce"));
    c.setSector(sectorDao.getById(Integer.parseInt(Util.getInputValue(request, "sector"))));

    return c;
  }
}
