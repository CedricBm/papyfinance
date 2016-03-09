package fr.papyfinance.com.forms;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.resources.Util;

public class AuthenticationForm {
  private UserDao userDao;

  public AuthenticationForm() {
    userDao = new UserDao();
  }

  public User getUser(HttpServletRequest request) {
    User user = userDao.getByLogin(Util.getInputValue(request, "login"));

    if (user != null && Arrays.equals(Util.encrypt(Util.getInputValue(request, "password")), user.getPassword())) {
      return user;
    }
    return null;
  }
}
