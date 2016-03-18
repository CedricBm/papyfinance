<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:company pageTitle="Publier une annonce">
  <div class="col s12">
    <h2 class="header center orange-text">Mes annonces</h2>
    <form class="col s6 offset-s3 hoverable" method="post">
      <div class="row">
        <c:if test="${ !empty error }">
          <div class="col s12 card-panel red lighten-1">${ error }</div>
        </c:if>
      </div>
      <div class="input-field col s6">
        <input id="title" name="title" type="text" class="validate" required aria-required="true"> <label for="title">Titre</label>
      </div>
      <div class="row">
        <div class="input-field col s12">
        <i class="material-icons prefix">mode_edit</i>
        <textarea  id="description" name="description" class="validate" required aria-required="true"></textarea><label for="description">Description</label>
        </div>
      </div>
      <div class="row">
        <button class="waves-effect waves-light btn" type="submit">Je publie!</button>
      </div>
      <input id="id_company" type="text" name="id_company" value="${user.company.id}"
                                style="display: none" />
       <input id="login" type="text" name="login" value="${user.login}"
                                style="display: none" />       
    </form>
  </div>
</layout:company>