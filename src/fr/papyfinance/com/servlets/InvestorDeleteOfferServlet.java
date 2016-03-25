package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.resources.Util;

@WebServlet("/investor/profile/delete")
public class InvestorDeleteOfferServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private OfferDao offerDao;
  @Inject
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("/PapyFinance/investor/profile");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    offerDao.delete(Integer.parseInt(request.getParameter("oid")));
    util.updateUser(request.getSession());
    doGet(request, response);
  }
}
