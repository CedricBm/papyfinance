package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.resources.Util;

@WebServlet("/investor/profile")
public class InvestorProfileServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Inject
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    util.updateUser(request.getSession());
    this.getServletContext().getRequestDispatcher("/WEB-INF/investor/profile.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
