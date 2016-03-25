<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>


<layout:investor pageTitle="Publier une offre">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s6 offset-s3">
          <h4 class="header center orange-text">Ajouter une offre</h4>
          
          <form class="col s12 hoverable" method="post">
            <div class="row">
              <div class="input-field col s12">
                <i class="material-icons prefix prefix-select">work</i> <select id="company" name="company" class="validate" required aria-required="true">
                  <option value="" disabled selected>Choisir une société</option>
                  <c:forEach var="company" items="${companies}">
                    <option value="${ company.id }">${ company.name }</option>
                  </c:forEach>
                </select> <label for="company">Société</label>
              </div>
            </div>

            <div class="row">
              <div class="input-field col s3">
                <i class="material-icons prefix">assessment</i> <input id="qte" name="qte" type="number" min="0" class="validate" required aria-required="true"> <label for="qte">Quantité</label>
              </div>
              <div class="input-field col s3">
                <input id="oprice" name="oprice" type="number" step="any" min="0" class="validate" required aria-required="true"> <label for="oprice">Prix</label>
              </div>
              <div class="input-field col s6">
                <select id="oofferType" name="oofferType" class="validate" required aria-required="true">
                  <option value="" disabled selected>Choisir le type de l'offre</option>
                  <option value="1">Achat</option>
                  <option value="2">Vente</option>
                </select> <label for="oofferType">Type de l'offre</label>
              </div>
            </div>

            <div class="row">
              <div class="input-field col s5">
                <select id="ocontratType" name="ocontratType" class="validate" required aria-required="true">
                  <option value="" disabled selected>Choisir le type du contrat</option>
                  <option value="1">Action</option>
                  <option value="2">Stock option</option>
                </select> <label for="ocontratType">Type du contrat</label>
              </div>

              <div class="input-field col s7">
                <select id="onegociationMode" name="onegociationMode" class="validate" required aria-required="true">
                  <option value="" disabled selected>Choisir le mode de négociation</option>
                  <option value="1">Prix fixe</option>
                  <option value="2">Enchere</option>
                </select> <label for="onegociationMode">Mode de négociation</label>
              </div>
            </div>

            <div class="row" id="champsDate">
              <div class="col s12">
                <label for="dateFin">Date de fin de l'enchère (dd/MM/yyyy hh:mm)</label>
                <input name="dateFin" type="datetime" id="dateFin">
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
</layout:investor>