<%@ tag body-content="scriptless"%>
<%@ attribute name="pageTitle" required="true" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle} - PapyFinance</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/materialize.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />

</head>
<body>
  <nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="${pageContext.request.contextPath}" class="brand-logo valign-wrapper"><img src="<c:url value="/img/logo.png" />" /></a>
      <a class='right hide-on-med-and-down dropdown-button menu' href='#' data-activates='dropdown1' data-constrainwidth="false" data-beloworigin="true">Bienvenue ${ user.fname }<i class="material-icons right">list</i></a>

      <ul id='dropdown1' class='dropdown-content'>
        <li><a class="waves-effect waves-light" href="#">Publier une offre</a></li>
        <li><a class="waves-effect waves-light" href="#">Mon profil</a></li>
        <li><a class="waves-effect waves-light" href="#">Acheter/Vendre</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/companies">Rechercher entreprises</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/offers">Rechercher offres</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/transactions">Rechercher transactions</a></li>
        <li class="divider"></li>
        <li><a href="${pageContext.request.contextPath}/logout">Déconnexion</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a class="waves-effect waves-light" href="#">Publier une offre</a></li>
        <li><a class="waves-effect waves-light" href="#">Mon profil</a></li>
        <li><a class="waves-effect waves-light" href="#">Acheter/Vendre</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/companies">Rechercher entreprises</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/offers">Rechercher offres</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/investor/search/transactions">Rechercher transactions</a></li>
        <li class="divider"></li>
        <li><a href="${pageContext.request.contextPath}/logout">Déconnexion</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  
  <jsp:include page="/WEB-INF/inc/flash.jsp" />

  <jsp:doBody />

  <footer class="page-footer orange">
    <div class="footer-copyright">
      <div class="container center-align">PapyFinance - ©2016 - Tous droits réservés</div>
    </div>
  </footer>

  <script src="<c:url value="/js/jquery-2.2.1.min.js" />"></script>
  <script src="<c:url value="/js/materialize.min.js" />"></script>
  <script src="<c:url value="/js/main.js" />"></script>
</body>
</html>