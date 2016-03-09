<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:connection pageTitle="Connexion">
  <div class="col s12">
    <h4 class="header center orange-text">Connexion à PapyFinance</h4>
    <form method="post" class="col s4 offset-s4 hoverable">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i> <input id="login" name="login" type="text" class="validate" required aria-required="true" autofocus> <label for="login">Login</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">security</i> <input id="password" name="password" type="password" class="validate" required aria-required="true"> <label for="password">Mot de passe</label>
        </div>
      </div>
      <div class="row">
        <button class="waves-effect waves-light btn" type="submit">Connexion</button>
      </div>
    </form>
  </div>
  <div class="col s12">
    <p class="light">
      Vous êtes un nouveau papy? <a href="signup">Inscrivez-vous.</a>
    </p>
  </div>
</layout:connection>