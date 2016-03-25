package fr.papyfinance.com.forms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.RoleDao;
import fr.papyfinance.com.resources.Util;

@Stateless
public class SubscribeCompanyForm {
  @EJB
  private RoleDao roleDao;
  @EJB
  private CompanyDao companyDao;
  @Inject
  private Util util;

  public User getUser(HttpServletRequest request) {
    User user = new User();
    String id_company;
    user.setLname(util.getInputValue(request, "lname"));
    user.setFname(util.getInputValue(request, "fname"));
    user.setEmail(util.getInputValue(request, "email"));
    id_company = util.getInputValue(request, "company");
    if (id_company != null) {
      user.setCompany(companyDao.getById(Integer.parseInt(id_company)));
    } else {
      user.setCompany(companyDao.getByName("Aucune société"));
    }
    user.setRole(roleDao.getByName("Membre société"));
    user.setConfirmed(false);

    return user;
  }
}
