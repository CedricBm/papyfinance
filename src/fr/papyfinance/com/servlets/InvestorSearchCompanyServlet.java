package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.SectorDao;
import fr.papyfinance.com.resources.Util;

@WebServlet("/investor/search/companies")
public class InvestorSearchCompanyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public InvestorSearchCompanyServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      CompanyDao cd = new CompanyDao();
      SectorDao sd = new SectorDao();
      String name = Util.getInputValue(request, "name");
      String sector = Util.getInputValue(request, "sector");
      String r = Util.getInputValue(request, "revenue");
      String w = Util.getInputValue(request, "workforce");
      long revenue = 0;
      long workforce = 0;
      if (name == null) {
        name = "";
      }
      if (sector == null) {
        sector = "";
      }
      if (r != null) {
        revenue = Long.parseLong(r);
      }
      if (w != null) {
        workforce = Long.parseLong(w);
      }
      ArrayList<Company> res = (ArrayList<Company>) cd.getAllForInvestor(name, sector, revenue, workforce);

      request.setAttribute("listeRes", res);
      request.setAttribute("sectors", sd.getAll());
    } catch (Exception e) {
      request.setAttribute("listeRes", null);
      request.setAttribute("sectors", new SectorDao().getAll());
    }finally
    {
      this.getServletContext().getRequestDispatcher("/WEB-INF/investor/search-companies.jsp").forward(request, response);
    }

    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
