<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:investor pageTitle="Liste des sociétés">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s8">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucune société à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered highlight">
                <thead>
                  <tr>
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
                      <td><a href="${pageContext.request.contextPath}/company?id=${company.id}">${company.name}</a></td>
                      <td>${company.revenue}</td>
                      <td><a href="${company.website}" target="_blank">${company.website}</a></td>
                      <td>${company.workforce}</td>
                      <td>${company.sector.name}</td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
        <div class="col s4">
          <div class="row">
            <form method="post" class="col s12 hoverable" action="../../investor/search/companies">
              <div class="row">
                <div class="input-field col s12">
                  <input id="name" name="name" type="text" class="validate"> <label for="name">Nom société :</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <select id="sector" name="sector" class="validate">
                    <option value="" disabled selected>Choisir un secteur</option>
                    <c:forEach var="sector" items="${sectors}">
                      <option value="${ sector.name }">${ sector.name }</option>
                    </c:forEach>
                  </select> <label for="sector">Secteur</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="revenue" name="revenue" type="text" class="validate"> <label for="revenue">Chiffre d'affaire supérieur à :</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="workforce" name="workforce" type="text" class="validate"> <label for="workforce">Nombre de salariés supérieur à :</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Rechercher</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:investor>
