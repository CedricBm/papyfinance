<%@ tag body-content="scriptless"%>
<%@ attribute name="pageTitle" required="true" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle}-PapyFinance</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/materialize.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />

</head>
<body>
  <nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="${pageContext.request.contextPath}" class="brand-logo valign-wrapper"><img src="<c:url value="/img/logo.png" />" /></a>
      <ul class="right hide-on-med-and-down">
        <li><a class="waves-effect waves-light" href="#">Connexion</a></li>
        <li><a class="waves-effect waves-light" href="#">Inscription Membre société</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a class="waves-effect waves-light" href="#">Connexion</a></li>
        <li><a class="waves-effect waves-light" href="#">Inscription Membre société</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>

  <jsp:doBody />

  <footer class="page-footer orange">
    <div class="footer-copyright">
      <div class="container center-align">PapyFinance - ©2016 - Tous droits réservés</div>
    </div>
  </footer>

  <script src="<c:url value="js/jquery-2.2.1.min.js" />"></script>
  <script src="<c:url value="js/materialize.min.js" />"></script>
  <script src="<c:url value="js/main.js" />"></script>
</body>
</html>