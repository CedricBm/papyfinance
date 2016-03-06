<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des sociétés à accréditer">
<div class="section no-pad-bot" id="index-banner">
 <div class="container">
  <br> <br>
  <div class="row center">
   <div class="col s12 m8">
	<div class="row center">
	 <c:choose>
	  <c:when test="${empty listeRes }">
		<p>Aucune société à afficher pour le moment !!</p>
	  </c:when>
	  <c:otherwise>
	   <table border="1">
		<tbody>
		<tr>
			<td align="center">ID</td>
			<td align="center">NAME</td>
			<td align="center">REVENUE</td>
			<td align="center">WEBSITE</td>
			<td align="center">WORKFORCE</td>
			<td align="center">SECTOR</td>
		</tr>
		</tbody>

		<c:forEach var="company" items="${listeRes}">
		<tbody>
			<tr>
			  <td align="center">${company.id}</td>
			  <td align="center">${company.name}</td>
			  <td align="center">${company.revenue}</td>
			  <td align="center"><a href="${company.website}">${company.website}</a></td>
			  <td align="center">${company.workforce}</td>
			  <td align="center">${company.sector.name}</td>
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