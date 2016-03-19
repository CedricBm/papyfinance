<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:company pageTitle="Ma société">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2>Edition de la société ${company.name}</h2>
          <form class="col s8 offset-s2 hoverable" method="post" action="${pageContext.request.contextPath}/company/edit?id=${company.id}">
            <div class="row">
              <div class="input-field col s12">
                <input id="name" name="name" type="text" class="validate" required aria-required="true" value="${company.name}"> <label for="name">Nom</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <input id="revenue" name="revenue" type="text" class="validate" required aria-required="true" value="${company.revenue}"> <label for="revenue">Chiffre d'affaire</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <input id="website" name="website" type="text" class="validate" required aria-required="true" value="${company.website}"> <label for="website">Site web</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <input id="workforce" name="workforce" type="text" class="validate" required aria-required="true" value="${company.workforce}"> <label for="workforce">Nombre d'employés</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <select id="sector" name="sector" class="validate">
                  <c:forEach var="sector" items="${sectors}">
                    <option value="${ sector.id }" <c:if test="${company.sector.id == sector.id}">selected</c:if>>${ sector.name }</option>
                  </c:forEach>
                </select> <label for="sector">Secteur</label>
              </div>
            </div>
            <div class="row">
              <button class="waves-effect waves-light btn" type="submit">Modifier</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</layout:company>