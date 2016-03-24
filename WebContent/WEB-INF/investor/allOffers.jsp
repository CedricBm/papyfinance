<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>


<layout:investor pageTitle="Liste des offres">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <div class="row center">
        <div class="col s12">
            <h4 class="header center orange-text">Les offres en cours </h4>
          <c:choose>
            <c:when test="${empty listeOffers }">
              <p>Aucune offre à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id Offre</th>
                    <th>Société</th>
                    <th>Quantité</th>
                    <th>Prix</th>
                    <th>Type de l'offre</th>
                    <th>Mode de négociation</th>
                    <th>Type du contrat</th>
                    <th>Prix total</th>
                    <th>Acheter</th>
                  </tr>
                </thead>

                <c:forEach var="offer" items="${listeOffers}">
                  <tbody>
                  <c:if test="${offer.valid}">
                    <tr>
                      <td>${offer.id}</td>
                      <td>${offer.company.name}</td>
                      <td>${offer.quantity}</td>
                      <td>${offer.price}</td>
                      <td>${offer.offerType.name}</td>
                      <td>${offer.negociationMode.name}</td>
                      <td>${offer.contractType.name}</td>
                      <td>${(offer.quantity)*(offer.price)}</td>
                      <td><c:choose>
						  <c:when test="${offer.negociationMode.id == 1}">
							<form method="post" action="../investor/offers/buy">
								<input id="role" type="text" name="role" value="company-member" style="display: none" /> <input id="oid" type="text" name="oid" value="${offer.id}" style="display: none" />
								<button class="waves-effect waves-light btn" type="submit">Acheter</button>
							</form>
						 </c:when>
						 <c:otherwise>
							<form method="post" action="../investor/offers/bid">
								<input id="role" type="text" name="role" value="company-member" style="display: none" /> <input id="oid" type="text" name="oid" value="${offer.id}" style="display: none" />
								<button class="waves-effect waves-light btn" type="submit">Encherir</button>
							</form>
						 </c:otherwise>
						</c:choose>
                      </td>
                    </tr>
                    </c:if>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
  </div>
  
</layout:investor>
