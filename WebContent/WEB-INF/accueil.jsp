<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:landing pageTitle="Accueil">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12 m8">
          <h2 class="header center orange-text">PapyFinance</h2>
          <div class="row center">
            <h5 class="header col s12 light">Le marché secondaire du parfait papy financier.</h5>
          </div>
        </div>
        <div class="col s12 m4">inscription</div>
      </div>
      <br> <br>
    </div>
  </div>

  <div class="container main">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text">
              <i class="material-icons">flash_on</i>
            </h2>
            <h5 class="center">Une inscription éclair</h5>

            <p class="light">Inscrivez-vous et vous pourrez effectuer des transactions dans la minute.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text">
              <i class="material-icons">group</i>
            </h2>
            <h5 class="center">Une communauté de papys</h5>

            <p class="light">Les meilleurs papys financiers sont présents pour vous fournir les meilleures offres.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text">
              <i class="material-icons">settings</i>
            </h2>
            <h5 class="center">Des transactions simplifiées</h5>

            <p class="light">Plus aucune prise de tête, toutes les meilleures offres pour papy sont rassemblées sur Papyfinance</p>
          </div>
        </div>
      </div>

    </div>
  </div>
</layout:landing>