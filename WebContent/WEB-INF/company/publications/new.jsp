<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:company pageTitle="Publier une annonce">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Ajouter une publication à ${company.name}</h2>
          <form class="col s6 offset-s3 hoverable" method="post" action="${pageContext.request.contextPath}/company/publications/new?id=${company.id}">
            <input type="hidden" name="id_company" value="${user.company.id}" />
            <div class="input-field col s12">
              <input id="title" name="title" type="text" class="validate" required aria-required="true"> <label for="title">Titre</label>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <textarea id="description" name="description" class="materialize-textarea" class="validate" required aria-required="true"></textarea>
                <label for="description">Description</label>
              </div>
            </div>
            <div class="row">
              <button class="waves-effect waves-light btn" type="submit">Publier</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</layout:company>