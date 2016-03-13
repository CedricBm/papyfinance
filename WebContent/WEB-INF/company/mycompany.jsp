<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:company pageTitle="Ma société">
 <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Nom société</th>
                    <th>Secteur</th>
                    <th>Website</th>
                    <th>Revenue</th>
                    <th>Workforce</th>
                    <th>Logo</th>
                  </tr>
                </thead>
                  <tbody>
                    <tr>
                      <td>${user.company.name}</td>
                      <td>${user.company.sector.name}</td>
                      <td>${user.company.website}</td>
                      <td>${user.company.revenue}</td>
                      <td>${user.company.workforce}</td>
                      <td><img src="${pageContext.request.contextPath}/WebContent/img/logos/${user.company.getLogo()}"></td>
                  </tbody>
              </table>
        </div>
      </div>
    </div>
  </div>
</layout:company>