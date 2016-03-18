<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:company pageTitle="Ma société">
 <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
        <h2 class="header orange-text">Ma société</h2>
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
        <div class="col s12">
        <h2 class="header orange-text">Mes annonces</h2>
              <table class="bordered">
                <thead>
                  <tr>
                    <th>Titre</th>
                    <th>Description</th>
                  </tr>
                </thead>
                <c:forEach var="user.company.publications" items="${listePublication}">
                  <tbody>
                    <tr>
                    	 <td><c:out value="${user.company.publications[title]}" /></td>
                    <td><c:out value="${user.company.publications[desciption]}" /></td>
					</tr>
                  </tbody>
                  </c:forEach>
              </table>
        </div>
      </div>
    </div>
  </div>
</layout:company>