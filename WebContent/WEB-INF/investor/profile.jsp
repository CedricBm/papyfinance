<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:investor pageTitle="Mon Profil">

  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <div class="row center">
        <div class="col s12">
          <h4 class="header center orange-text">Votre profile</h4>
          <p>Nom: ${user.lname}</p>
          <p>Prénom: ${user.fname}</p>
          <p>Login: ${user.login}</p>
          <p>Email: ${user.email}</p>
        </div>
      </div>
      <div class="row center">
        <div class="col s12">
          <h4 class="header center orange-text">Vos offres</h4>
          <c:choose>
            <c:when test="${empty user.offers }">
              <p>Vous n'avez publié aucune offre !!</p>
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
                    <th>Supprimer</th>
                  </tr>
                </thead>

                <c:forEach var="offer" items="${user.offers}">
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
                          <c:when test="${offer.valid}">
                            <form method="post" action="../investor/profile/delete">
                              <input id="role" type="text" name="role" value="company-member" style="display: none" /> <input id="oid" type="text" name="oid" value="${offer.id}" style="display: none" />
                              <button class="waves-effect waves-light btn" type="submit">Supprimer</button>
                            </form>
                          </c:when>
                          <c:otherwise>
                            <a class="btn disabled">Vendue !</a>
                          </c:otherwise>
                        </c:choose></td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
      </div>

      <div class="row center">
        <div class="col s12">
          <h4 class="header center orange-text">Vos transactions (acheteur)</h4>
          <c:choose>
            <c:when test="${empty user.transactionsBought}">
              <p>Vous n'avez pas de transaction !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered highlight">
                <thead>
                  <tr>
                    <th>Id Transaction</th>
                    <th>Société</th>
                    <th>Quantité</th>
                    <th>Prix unitaire</th>
                    <th>Type de l'offre</th>
                    <th>Mode de négociation</th>
                    <th>Type du contrat</th>
                    <th>Prix total</th>
                    <th>Vendeur</th>
                  </tr>
                </thead>

                <c:forEach var="transaction" items="${user.transactionsBought}">
                  <tbody>
                    <tr>
                      <td>${transaction.offer.id}</td>
                      <td>${transaction.offer.company.name}</td>
                      <td>${transaction.offer.quantity}</td>
                      <td>${transaction.offer.price}</td>
                      <td>${transaction.offer.offerType.name}</td>
                      <td>${transaction.offer.negociationMode.name}</td>
                      <td>${transaction.offer.contractType.name}</td>
                      <td>${(transaction.offer.quantity)*(transaction.offer.price)}</td>
                      <td>${transaction.buyer.login}</td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
      </div>

      <div class="row center">
        <div class="col s12">
          <h4 class="header center orange-text">Vos transactions (vendeur)</h4>
          <c:choose>
            <c:when test="${empty user.transactionsSold}">
              <p>Vous n'avez pas de transaction !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered highlight">
                <thead>
                  <tr>
                    <th>Id Transaction</th>
                    <th>Société</th>
                    <th>Quantité</th>
                    <th>Prix unitaire</th>
                    <th>Type de l'offre</th>
                    <th>Mode de négociation</th>
                    <th>Type du contrat</th>
                    <th>Prix total</th>
                    <th>Vendeur</th>
                  </tr>
                </thead>

                <c:forEach var="transaction" items="${user.transactionsSold}">
                  <tbody>
                    <tr>
                      <td>${transaction.offer.id}</td>
                      <td>${transaction.offer.company.name}</td>
                      <td>${transaction.offer.quantity}</td>
                      <td>${transaction.offer.price}</td>
                      <td>${transaction.offer.offerType.name}</td>
                      <td>${transaction.offer.negociationMode.name}</td>
                      <td>${transaction.offer.contractType.name}</td>
                      <td>${(transaction.offer.quantity)*(transaction.offer.price)}</td>
                      <td>${transaction.buyer.login}</td>
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
</layout:investor>
