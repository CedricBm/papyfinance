<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des investisseurs">
<div class="section no-pad-bot" id="index-banner">
 <div class="container">
  <br> <br>
  <div class="row center">
   <div class="col s12 m8">
	<div class="row center">
	 <c:choose>
	  <c:when test="${empty listeUsers }">
		<p>Liste des investisseurs est vide !!</p>
	  </c:when>
	  <c:otherwise>
	   <table border="1">
		<tbody>
		<tr>
			<td align="center">ID</td>
			<td align="center">IS_CONFIRMED</td>
			<td align="center">EMAIL</td>
			<td align="center">FNAME</td>
			<td align="center">LNAME</td>
			<td align="center">LOGIN</td>
			<td align="center">COMPANY_ID</td>
			<td align="center">ACTIVER/DESACTIVER</td>
		</tr>
		</tbody>

		<c:forEach var="user" items="${listeUsers}">
		<tbody>
			<tr>
			  <td align="center">${user.id}</td>
			  <td align="center">${user.confirmed}</td>
			  <td align="center">${user.email}</td>
			  <td align="center">${user.fname}</td>
			  <td align="center">${user.lname}</td>
			  <td align="center">${user.login}</td>
			  <td align="center">${user.company.name}</td>
			  <td align="center">
			  <c:choose>
			  <c:when test="${user.confirmed}">
			   <form method="post" action="../admin/desactivate">
			    <input id="role" type="text" name="role" value="investor" style="display:none" />
				<input id="email" type="text" name="email" value="${user.email}" style="display:none" />
				<button class="waves-effect waves-light btn" type="submit">DESACTIVER</button>
			   </form>
			  </c:when>
			  <c:otherwise>
			   <form method="post" action="../admin/activate">
			    <input id="role" type="text" name="role" value="investor" style="display:none" />
				<input id="email" type="text" name="email" value="${user.email}" style="display: none" />
				<button class="waves-effect waves-light btn" type="submit">ACTIVER</button>
			   </form>
			  </c:otherwise>
			 </c:choose>
		     </td>
		   </tr>
		  </tbody>
		 </c:forEach>
		</table>
	   </c:otherwise>
	  </c:choose>
	 </div>
	</div>
  </div>
 </div>
</div>
</layout:admin>