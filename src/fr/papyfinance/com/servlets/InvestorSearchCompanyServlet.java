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

/**
 * Servlet implementation class InvestorSearchCompanyServlet
 */
@WebServlet("/investor/search/companies")
public class InvestorSearchCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvestorSearchCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CompanyDao cd = new CompanyDao();
		SectorDao sd = new SectorDao();
		String name = Util.getInputValue(request, "name");
		String sector = Util.getInputValue(request, "sector");
		String r = Util.getInputValue(request, "revenue");
		String w = Util.getInputValue(request, "workforce");
		long revenue;
		long workforce;
		if(name == null){
			name = "";
		}
		if(sector == null){
			sector = "";
		}
		if(r == null){
			revenue = 0;
		}else
		{
			revenue = Long.parseLong(r);
		}
		if(w == null){
			workforce = 0;
		}else
		{
			workforce = Long.parseLong(w);
		}
		
		ArrayList<Company> res = (ArrayList<Company>) cd.getAllForInvestor(name,sector,revenue,workforce);
		
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBB"+res.size());
		request.setAttribute("listeRes", res);
		request.setAttribute("sectors", sd.getAll());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/investor/search-companies.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
