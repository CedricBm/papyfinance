package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.dao.CompanyDao;

@WebServlet(urlPatterns = { "/company/logo" })
public class LogoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private CompanyDao cd;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    byte[] logo;
    if (request.getParameter("id") == null) {
      logo = cd.getByName("Aucune société").getLogo();
    } else {
      logo = cd.getById(Integer.parseInt(request.getParameter("id"))).getLogo();
    }
    response.setContentLength(logo.length);
    response.getOutputStream().write(logo);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}