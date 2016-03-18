package fr.papyfinance.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.resources.Util;

@WebServlet( urlPatterns = {"/WebContent/img/logos/*"} )
public class GetImageServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String imageName = request.getPathInfo().substring(1); // Returns "logo.png".
    CompanyDao cd = new CompanyDao();
    byte[] content = cd.getByLogo( Util.currentUser(request.getSession()).getCompany().getLogo() );
    response.setContentType(getServletContext().getMimeType(imageName));
    response.setContentLength(content.length);
    response.getOutputStream().write(content);	            
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }


}