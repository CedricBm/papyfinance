<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Administration">
  <div class="col s12">
    <form method="post" class="col s4 offset-s4 hoverable" action="admin/search">
      <div class="row">
        <div class="input-field col s12">
          <input id="search" name="search" type="text" class="validate"> <label for="search">Valeur recherchée</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <select id="typeSearch" name="typeSearch" size="1">
            <option value=1>Société</option>
            <option value=2>Utilisateur</option>
            <option value=3>Offre</option>
            <option value=4>Transaction</option>
          </select> <label for="typeSearch">Type recherchée</label>
        </div>
      </div>
      <div class="row">
        <button class="waves-effect waves-light btn" type="submit">Rechercher</button>
      </div>
    </form>
  </div>
</layout:admin>