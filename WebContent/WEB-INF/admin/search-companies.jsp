<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des sociétés">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucune société à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id société</th>
                    <th>Nom</th>
                    <th>Chiffre d'affaire</th>
                    <th>Site web</th>
                    <th>Nombre d'employés</th>
                    <th>Secteur d'activité</th>
                  </tr>
                </thead>

                <c:forEach var="company" items="${listeRes}">
                  <tbody>
                    <tr>
                      <td>${company.id}</td>
                      <td>${company.name}</td>
                      <td>${company.revenue}</td>
                      <td><a href="${company.website}">${company.website}</a></td>
                      <td>${company.workforce}</td>
                      <td>${company.sector.name}</td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
  </div>
</layout:admin>
