<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:company pageTitle="Modifier une annonce">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Voulez-vous vraiment supprimer la publication ${publication.title} de ${company.name}?</h2>
          <form class="col s6 offset-s3" method="post" action="${pageContext.request.contextPath}/company/publications/delete?id=${publication.id}&company_id=${company.id}">
            <div class="row">
              <button class="waves-effect waves-light btn" type="submit">Supprimer</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</layout:company>