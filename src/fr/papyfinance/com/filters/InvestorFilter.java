package fr.papyfinance.com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.papyfinance.com.beans.User;

@WebFilter(urlPatterns = { "/investor/*", "/investor" })
public class InvestorFilter implements Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession();

    User u = (User) session.getAttribute("user");
    if (u != null && (u.getRole().getName().equals("Administrateur") || u.getRole().getName().equals("Investisseur"))) {
      chain.doFilter(request, response);
    } else {
      session.setAttribute("unauthorized", "Vous n'avez pas le droit d'accéder à cette page!");
      response.sendRedirect("/PapyFinance");
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
  }
}
