<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="light-blue lighten-1" role="navigation">
  <div class="nav-wrapper container">
    <a id="logo-container" href="${pageContext.request.contextPath}" class="brand-logo valign-wrapper"><img src="<c:url value="/img/logo.png" />" /></a> <a
      class='right hide-on-med-and-down dropdown-button menu' href='#' data-activates='dropdown1' data-constrainwidth="false" data-beloworigin="true">Bienvenue ${ user.fname }<i
      class="material-icons right">list</i></a>

    <ul id='dropdown1' class='dropdown-content'>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/postOffer">Publier une offre</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/profile">Mon profil</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/offers">Toutes les offres</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/companies">Rechercher entreprises</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/transactions">Rechercher transactions</a></li>
      <li class="divider"></li>
      <li><a href="${pageContext.request.contextPath}/logout">Déconnexion</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/postOffer">Publier une offre</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/profile">Mon profil</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/offers">Toutes les offres</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/companies">Rechercher entreprises</a></li>
      <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/transactions">Rechercher transactions</a></li>
      <li class="divider"></li>
      <li><a href="${pageContext.request.contextPath}/logout">Déconnexion</a></li>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>