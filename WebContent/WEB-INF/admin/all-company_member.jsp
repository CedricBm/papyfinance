<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des membres société">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <c:choose>
            <c:when test="${empty listeUsers }">
              <p>Liste des membre société est vide !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id utilisateur</th>
                    <th>Email</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Login</th>
                    <th>Nom société</th>
                    <th>Activer/Désactiver</th>
                  </tr>
                </thead>

                <c:forEach var="user" items="${listeUsers}">
                  <tbody>
                    <tr>
                      <td>${user.id}</td>
                      <td>${user.email}</td>
                      <td>${user.fname}</td>
                      <td>${user.lname}</td>
                      <td>${user.login}</td>
                      <td>${user.company.name}</td>
                      <td><c:choose>
                          <c:when test="${user.confirmed}">
                            <form method="post" action="../admin/deactivate">
                              <input id="role" type="text" name="role" value="company-member" style="display: none" /> <input id="email" type="text" name="email" value="${user.email}"
                                style="display: none" />
                              <button class="waves-effect waves-light btn" type="submit">DESACTIVER</button>
                            </form>
                          </c:when>
                          <c:otherwise>
                            <form method="post" action="../admin/activate">
                              <input id="role" type="text" name="role" value="company-member" style="display: none" /> <input id="email" type="text" name="email" value="${user.email}"
                                style="display: none" />
                              <button class="waves-effect waves-light btn" type="submit">ACTIVER</button>
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
      </div>
    </div>
  </div>
</layout:admin>
