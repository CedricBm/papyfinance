<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des transactions">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucune transaction à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id transaction</th>
                    <th>Nom acheteur</th>
                    <th>Nom vendeur</th>
                    <th>Société</th>
                    <th>Id offre</th>
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
