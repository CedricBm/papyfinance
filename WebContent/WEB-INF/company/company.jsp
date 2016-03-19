<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:company pageTitle="${company.name}">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header orange-text">${company.name}</h2>
          <c:if test="${not empty company.logo}">
            <img src="${pageContext.request.contextPath}/company/logo?id=${company.id}">
          </c:if>
          <p>Secteur: ${company.sector.name}</p>
          <p>
            Site web: <a href="${company.website}" target="_blank">${company.website}</a>
          </p>
          <p>Chiffre d'affaire: ${company.revenue}</p>
          <p>Nombre d'employés: ${company.workforce}</p>
          <c:if test="${user.company.id == company.id}">
            <p>
              <a href="company/edit?id=${company.id}" class="waves-effect waves-light btn">Modifier la société</a>
            </p>
          </c:if>
        </div>
        <div class="col s12">
          <h2 class="header orange-text">Publications</h2>
          <c:if test="${user.company.id == company.id}">
            <p>
              <a href="company/publications/new?id=${company.id}" class="waves-effect waves-light btn">Ajouter une publication</a>
            </p>
          </c:if>
          <table class="bordered highlight centered">
            <thead>
              <tr>
                <th>Titre</th>
                <th>Description</th>
                <c:if test="${user.company.id == company.id}">
                  <th>Modifier</th>
                  <th>Supprimer</th>
                </c:if>
              </tr>
            </thead>
            <c:forEach var="publication" items="${company.publications}">
              <tbody>
                <tr>
                  <td>${publication.title}</td>
                  <td class="pre-wrap">${publication.description}</td>
                  <c:if test="${user.company.id == company.id}">
                    <td><a href="company/publications/edit?id=${publication.id}&company_id=${company.id}" class="waves-effect waves-light btn">Modifier</a></td>
                    <td><a href="company/publications/delete?id=${publication.id}&company_id=${company.id}" class="waves-effect waves-light btn">Supprimer</a></td>
                  </c:if>
                </tr>
              </tbody>
            </c:forEach>
          </table>
        </div>
      </div>
    </div>
  </div>
</layout:company>