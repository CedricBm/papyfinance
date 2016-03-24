<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:investor pageTitle="Liste des offres">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s9">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucune offre à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered highlight">
                <thead>
                  <tr>
                    <th>Id Offre</th>
                    <th>Société</th>
                    <th>Quantité</th>
                    <th>Prix unitaire</th>
                    <th>Type de l'offre</th>
                    <th>Mode de négociation</th>
                    <th>Type du contrat</th>
                    <th>Prix total</th>
                    <th>Acheter</th>
                  </tr>
                </thead>

                <c:forEach var="offer" items="${listeRes}">
                  <tbody>
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
                          <c:when test="${user.id == offer.user.id}">C'est votre offre</c:when>
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
                        </c:choose></td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>

        <div class="col s3">
          <div class="row">
            <form method="post" class="col s12 hoverable" action="../investor/offers">
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
