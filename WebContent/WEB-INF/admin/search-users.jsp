<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des investisseurs">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <c:choose>
            <c:when test="${empty listeRes }">
              <p>Aucun utilisateur à afficher pour le moment !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id utilisateur</th>
                    <th>Est confirmé</th>
                    <th>Email</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Login</th>
                    <th>Société</th>
                    <th>Rôle</th>
                  </tr>
                </thead>

                <c:forEach var="user" items="${listeRes}">
                  <tbody>
                    <tr>
                      <td>${user.id}</td>
                      <td>${user.confirmed}</td>
                      <td>${user.email}</td>
                      <td>${user.fname}</td>
                      <td>${user.lname}</td>
                      <td>${user.login}</td>
                      <td>${user.company.name}</td>
                      <td>${user.role.name}</td>
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
