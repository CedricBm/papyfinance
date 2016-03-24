<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="light-blue lighten-1" role="navigation">
  <div class="nav-wrapper container">
    <a id="logo-container" href="${pageContext.request.contextPath}" class="brand-logo valign-wrapper"><img src="<c:url value="/img/logo.png" />" /></a> <a
      class='right hide-on-med-and-down dropdown-button menu' href='#' data-activates='dropdown1' data-constrainwidth="false" data-beloworigin="true">Bienvenue ${ user.fname }<i
      class="material-icons right">list</i></a>

    <ul id='dropdown1' class='dropdown-content'>
      <c:choose>
        <c:when test="${user.company.id == 1}">
          <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/company/new">Rajouter ma société</a></li>
        </c:when>
        <c:otherwise>
          <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/company?id=${user.company.id}">Ma société</a></li>
        </c:otherwise>
      </c:choose>
      <li class="divider"></li>
      <li><a href="${pageContext.request.contextPath}//logout">Déconnexion</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <c:choose>
        <c:when test="${user.company.id == 1}">
          <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/company/new">Rajouter ma société</a></li>
        </c:when>
        <c:otherwise>
          <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/company?id=${user.company.id}">Ma société</a></li>
        </c:otherwise>
      </c:choose>
      <li class="divider"></li>
      <li><a href="${pageContext.request.contextPath}//logout">Déconnexion</a></li>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>