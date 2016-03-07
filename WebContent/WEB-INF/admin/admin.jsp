<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Administration">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12 m8">
          <div class="row center">
            <form class="col s12 hoverable" method="post" action="admin/search">
              <div class="row">
              <div class="input-field col s6">
                  <input id="search" name="search" type="text" class="validate"> <label for="search">Veuillez entrer la valeur que vous recherchez</label>
                </div>
              </div>
              <div class="row">
              <div class="input-field col s6">
                <select name="typeSearch" size="1">
                  <option value=1>Société</option>
                  <option value=2>Utilisateur</option>
                  <option value=3>Offre</option>
                  <option value=4>Transaction</option>
                 </select>
                 </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Rechercher</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:admin>