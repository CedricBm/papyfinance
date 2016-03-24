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
  <jsp:include page="/WEB-INF/inc/investorMenu.jsp" />

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