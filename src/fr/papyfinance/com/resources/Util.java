package fr.papyfinance.com.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.UserDao;

@Stateless
public class Util {
  @EJB
  private UserDao ud;

  public String getInputValue(HttpServletRequest request, String inputName) {
    String value = request.getParameter(inputName);
    if (value == null || value.trim().length() == 0) {
      return null;
    } else {
      return value.trim();
    }
  }

  public void login(User u, HttpSession session) {
    session.setAttribute("user", u);
  }

  public void logout(HttpSession session) {
    session.invalidate();
  }

  public void updateUser(HttpSession session) {
    User u = currentUser(session);
    u = ud.getById(u.getId());
    session.setAttribute("user", u);
  }

  public User currentUser(HttpSession session) {
    return (User) session.getAttribute("user");
  }

  public byte[] encrypt(String password) {
    try {
      java.security.MessageDigest d = null;
      d = java.security.MessageDigest.getInstance("SHA-256");
      d.reset();
      d.update(password.getBytes());
      return d.digest();
    } catch (Throwable ex) {
      System.err.println("Encryption failed. " + ex);
    }
    return null;
  }
}
