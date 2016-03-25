package fr.papyfinance.com.forms;

import java.util.Arrays;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.resources.Util;

@Stateless
public class AuthenticationForm {
  @EJB
  private UserDao userDao;
  @Inject
  private Util util;

  public User getUser(HttpServletRequest request) {
    User user = userDao.getByLogin(util.getInputValue(request, "login"));

    if (user != null && Arrays.equals(util.encrypt(util.getInputValue(request, "password")), user.getPassword())) {
      return user;
    }
    return null;
  }
}
