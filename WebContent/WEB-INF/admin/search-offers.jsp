<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des offres">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucune offre à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id offre</th>
                    <th>Prix</th>
                    <th>Quantité</th>
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
                      <td>${offer.id}</td>
                      <td>${offer.price}</td>
                      <td>${offer.quantity}</td>
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
      </div>
    </div>
  </div>
</layout:admin>
