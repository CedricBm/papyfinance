<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:investor pageTitle="Liste des transactions">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s8">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucune transaction à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered highlight">
                <thead>
                  <tr>
                    <th>Id transaction</th>
                    <th>Nom acheteur</th>
                    <th>Nom vendeur</th>
                    <th>Société</th>
                    <th>Id offre</th>
                    <th>Prix total</th>
                  </tr>
                </thead>

                <c:forEach var="transaction" items="${listeRes}">
                  <tbody>
                    <tr>
                      <td>${transaction.id}</td>
                      <td>${transaction.buyer.lname}</td>
                      <td>${transaction.seller.lname}</td>
                      <td>${transaction.company.name}</td>
                      <td>${transaction.offer.id}</td>
                      <td>${transaction.totalPrice}</td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
        <div class="col s4">
          <div class="row">
            <form method="post" class="col s12 hoverable" action="../../investor/search/transactions">
              <div class="row">
                <div class="input-field col s12">
                  <input id="buyerName" name="buyerName" type="text" class="validate"> <label for="buyerName">Nom acheteur :</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="sellerName" name="sellerName" type="text" class="validate"> <label for="sellerName">Nom vendeur :</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="companyName" name="companyName" type="text" class="validate"> <label for="companyName">Nom entreprise :</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="idOffer" name="idOffer" type="text" class="validate"> <label for="idOffer">Id de l'offre :</label>
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
