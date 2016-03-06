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
	  <c:when test="${empty listeRes }">
		<p>Aucune offre à afficher pour le moment !!</p>
	  </c:when>
	  <c:otherwise>
	   <table border="1">
		<tbody>
		<tr>
			<td align="center">ID</td>
			<td align="center">PRICE</td>
			<td align="center">QUANTITY</td>
			<td align="center">OFFERTYPE</td>
			<td align="center">NEGOCIATIONMODE</td>
			<td align="center">CONTRACTTYPE</td>
			<td align="center">USER</td>
			<td align="center">COMPANY</td>
		</tr>
		</tbody>

		<c:forEach var="offer" items="${listeRes}">
		<tbody>
			<tr>
			  <td align="center">${offer.id}</td>
			  <td align="center">${offer.price}</td>
			  <td align="center">${offer.quantity}</td>
			  <td align="center">${offer.offerType.name}</td>
			  <td align="center">${offer.negociationMode.name}</td>
			  <td align="center">${offer.contractType.name}</td>
			  <td align="center">${offer.user.name}</td>
			  <td align="center">${offer.company.name}</td>
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