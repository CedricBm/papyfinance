package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import fr.papyfinance.com.resources.Util;

@WebServlet( urlPatterns = {"/WebContent/img/logos/*"} )
public class GetImageServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

private static final String SQL_FIND = "SELECT logo FROM companies where id = ";

final String dbURL = "jdbc:mysql://localhost:3306/papyfinance";
final String dbUser = "root";
final String dbPass = "yassine";

Connection conn = null;
Statement stmt = null;

//@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageName = request.getPathInfo().substring(1); // Returns "logo.png".

        try {
        Class.forName("com.mysql.jdbc.Driver");

        conn = (Connection) DriverManager.getConnection(dbURL, dbUser, dbPass);
        System.out.println("db connected");
        stmt = (Statement) conn.createStatement();

        java.sql.ResultSet resultSet;
        resultSet = stmt.executeQuery( SQL_FIND  + Util.currentUser(request.getSession()).getCompany().getId());
        
        
        if (resultSet.next()) {
                byte[] content = resultSet.getBytes("logo");
                response.setContentType(getServletContext().getMimeType(imageName));
                response.setContentLength(content.length);
                response.getOutputStream().write(content);
	            }
        }
         catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }


}