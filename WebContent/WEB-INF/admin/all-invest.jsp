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