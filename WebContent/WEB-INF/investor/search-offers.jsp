<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:investor pageTitle="Liste des offres">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s6">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucune offre à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Prix</th>
                    <th>Type offre</th>
                    <th>Mode de négociation</th>
                    <th>Type contrat</th>
                    <th>Nom vendeur</th>
                    <th>Société</th>
                  </tr>
                </thead>

                <c:forEach var="offer" items="${listeRes}">
                  <tbody>
                    <tr>
                      <td>${offer.price}</td>
                      <td>${offer.offerType.name}</td>
                      <td>${offer.negociationMode.name}</td>
                      <td>${offer.contractType.name}</td>
                      <td>${offer.user.lname}</td>
                      <td>${offer.company.name}</td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
        <div class="col s6">
          <div class="row">
            <form method="post" class="col s6 offset-s6 hoverable" action="../../investor/search/offers">
              <div class="row">
                <div class="input-field col s12">
                  <input id="price" name="price" type="text" class="validate"> <label for="price">Prix supérieur à :</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <select id="offerType" name="offerType" class="validate">
                    <option value="" disabled selected>Choisir un type d'offre</option>
                    <c:forEach var="offerType" items="${offerTypes}">
                      <option value="${ offerType.name }">${ offerType.name }</option>
                    </c:forEach>
                  </select> <label for="offerType">Type Offre</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <select id="negociationMode" name="negociationMode" class="validate">
                    <option value="" disabled selected>Choisir un mode de négociation</option>
                    <c:forEach var="negociationMode" items="${negociationModes}">
                      <option value="${ negociationMode.name }">${ negociationMode.name }</option>
                    </c:forEach>
                  </select> <label for="negociationMode">Mode de négociation</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <select id="contractType" name="contractType" class="validate">
                    <option value="" disabled selected>Choisir un type de contrat</option>
                    <c:forEach var="contractType" items="${contractTypes}">
                      <option value="${ contractType.name }">${ contractType.name }</option>
                    </c:forEach>
                  </select> <label for="contractType">Type de contrat</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="seller" name="seller" type="text" class="validate"> <label for="seller">Nom du vendeur :</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="company" name="company" type="text" class="validate"> <label for="company">Nom de la société :</label>
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
