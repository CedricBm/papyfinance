<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${ !empty alert }">
  <div class="container">
    <div class="row center">
      <div class="col s8 offset-s2 card-panel red z-depth-2 flash">${ alert }</div>
    </div>
  </div>
</c:if>
<c:if test="${ !empty success }">
  <div class="container">
    <div class="row center">
      <div class="col s8 offset-s2 card-panel green z-depth-2 flash">${ success }</div>
    </div>
  </div>
</c:if>
<c:if test="${ !empty notice }">
  <div class="container">
    <div class="row center">
      <div class="col s8 offset-s2 card-panel blue z-depth-2 flash">${ notice }</div>
    </div>
  </div>
</c:if>