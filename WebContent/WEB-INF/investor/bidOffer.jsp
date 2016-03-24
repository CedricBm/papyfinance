<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>


<layout:investor pageTitle="Enchérir">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <div class="row center">
        <div class="col s12">
            <h4 class="header center orange-text">Donner un prix</h4>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id Offre</th>
                    <th>Vendeur</th>
                    <th>Société</th>
                    <th>Quantité</th>
                    <th>Prix</th>
                    <th>Type de l'offre</th>
                    <th>Mode de négociation</th>
                    <th>Type du contrat</th>
                    <th>Prix total</th>
                  </tr>
                </thead>
                  <tbody>
                    <tr>
                      <td>${offer.id}</td>
                      <td>${offer.user.login}</td>
                      <td>${offer.company.name}</td>
                      <td>${offer.quantity}</td>
                      <td>${offer.price}</td>
                      <td>${offer.offerType.name}</td>
                      <td>${offer.negociationMode.name}</td>
                      <td>${offer.contractType.name}</td>
                      <td>${(offer.quantity)*(offer.price)}</td>
                    </tr>
                  </tbody>

              </table>
        </div>
      </div>
      
      
	  <div class="row center">
        <div class="col s6">
            <h4 class="header center orange-text">les offres precedentes</h4>
            <c:choose>
            <c:when test="${empty listAuctionOffers }">
              <p>Aucune transaction à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id Offre</th>
                    <th>Acheteur</th>
                    <th>Date</th>
                    <th>Prix</th>
                  </tr>
                </thead>
				<c:forEach var="auctionOffer" items="${listAuctionOffers}">
                  <tbody>
                    <tr>
                      <td>${auctionOffer.id}</td>
                      <td>${auctionOffer.user.login}</td>
                      <td>${auctionOffer.auction.dateFin}</td>
                      <td>${auctionOffer.amount}</td>

                    </tr>
                  </tbody>
                </c:forEach>
              </table>
			</c:otherwise>
          </c:choose>
        </div>
        
        
        <div class="col s6">
            <h4 class="header center orange-text">Votre prix</h4>
                <form class="hoverable" method="post" action="../offers/bid/setAuction">
                 <input id="oid" type="text" name="oid" value="${offer.id}" style="display: none" />
	                <div class="input-field col s3">
	          			<input id="price" name="price" type="number" step="any" class="validate" required aria-required="true"> <label for="price">Prix</label>
	        		</div>
	        		<div class="input-field col s3 offset-s4">	
						<button class="waves-effect waves-light btn" type="submit">Valider</button>
					</div>
                </form>
        </div>
      </div>
	  
      
    </div>
  </div>
  
</layout:investor>
