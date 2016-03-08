<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Activation compte">
  <div class="col s12">
    <h4 class="header center orange-text">Activation du compte de ${email}</h4>
    <form method="post" action="../admin/activate">
      <input id="email" type="text" name="email" value="${email}" style="display: none" /> <input id="role" type="text" name="role" value="company-member" style="display: none" />
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i> <input id="login" name="login" type="text" class="validate" required aria-required="true"> <label for="login">Login</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i> <input id="password" name="password" type="password" class="validate" required aria-required="true"> <label for="password">Mot
            de passe</label>
        </div>
      </div>
      <div class="row">
        <button class="waves-effect waves-light btn" type="submit">Activer</button>
      </div>
    </form>
  </div>
</layout:admin>