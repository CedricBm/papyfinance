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
public class SubscribeForm {
  @EJB
  private RoleDao roleDao;
  @EJB
  private CompanyDao companyDao;
  @Inject
  private Util util;

  public User getUser(HttpServletRequest request) {
    User user = new User();
    user.setLname(util.getInputValue(request, "lname"));
    user.setFname(util.getInputValue(request, "fname"));
    user.setEmail(util.getInputValue(request, "email"));
    user.setLogin(util.getInputValue(request, "login"));
    user.setPassword(util.encrypt(util.getInputValue(request, "password")));
    user.setRole(roleDao.getByName("Investisseur"));
    user.setCompany(companyDao.getByName("Aucune société"));
    user.setConfirmed(false);

    return user;
  }
}
