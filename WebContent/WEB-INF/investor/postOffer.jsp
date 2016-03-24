<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>


<layout:investor pageTitle="Publier une offre">
  <div class="col s12">
    <h4 class="header center orange-text">Ajouter une offre</h4>
    <form class="hoverable" method="post">

      <div class="row">
        <div class="input-field col s7 offset-s2">
          <i class="material-icons prefix prefix-select">work</i> <select id="company" name="company" class="validate">
            <option value="" disabled selected>Choisir une société</option>
            <c:forEach var="company" items="${companies}">
              <option value="${ company.id }">${ company.name }</option>
            </c:forEach>
          </select> <label for="company">Société</label>
        </div>
      </div>

      <div class="row">
        <div class="input-field col s2 offset-s2">
          <i class="material-icons prefix">assessment</i> <input id="qte" name="qte" type="number" class="validate" required aria-required="true"> <label for="qte">Quantité</label>
        </div>
        <div class="input-field col s2">
          <input id="oprice" name="oprice" type="number" step="any" class="validate" required aria-required="true"> <label for="oprice">Prix</label>
        </div>
        <div class="input-field col s3">
          <select id="oofferType" name="oofferType" class="validate">
            <option value="" disabled selected>Choisir le type de l'offre</option>
            <option value="1">Achat</option>
            <option value="2">Vente</option>
          </select> <label for="oofferType">Type de l'offre</label>
        </div>
      </div>


      <div class="row">
        <div class="input-field col s3 offset-s2">
          <select id="ocontratType" name="ocontratType" class="validate">
            <option value="" disabled selected>Choisir le type du contrat</option>
            <option value="1">Action</option>
            <option value="2">Stock option</option>
          </select> <label for="ocontratType">Type du contrat</label>
        </div>

        <div class="input-field col s4">
          <select id="onegociationMode" name="onegociationMode" class="validate">
            <option value="" disabled selected>Choisir le mode de négociation</option>
            <option value="1">Prix fixe</option>
            <option value="2">Enchere</option>
          </select> <label for="onegociationMode">Mode de négociation</label>
        </div>
      </div>

      <div class="row" id="champsDate">
        <div class="input-field col s3 offset-s4">
          <i class="material-icons prefix">today</i> <input type="date" class="validate" required aria-required="true">

        </div>
      </div>

      <div class="row">
        <div class="input-field offset-s6">
          <button class="waves-effect waves-light btn" type="submit">Publier</button>
        </div>
      </div>


    </form>
  </div>

</layout:investor>