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
		<p>Aucun utilisateur à afficher pour le moment !!</p>
	  </c:when>
	  <c:otherwise>
	   <table border="1">
		<tbody>
		<tr>
			<td align="center">ID</td>
			<td align="center">BUYERFIXED</td>
			<td align="center">SELLERFIXED</td>
			<td align="center">OFFERFIXED</td>
			<td align="center">COMPANYFIXED</td>
			<td align="center">CONTRACTFIXED</td>
			<td align="center">BUYER</td>
			<td align="center">SELLER</td>
			<td align="center">COMPANY</td>
			<td align="center">OFFER</td>
		</tr>
		</tbody>

		<c:forEach var="transaction" items="${listeRes}">
		<tbody>
			<tr>
			  <td align="center">${transaction.id}</td>
			  <td align="center">${transaction.buyerFixed}</td>
			  <td align="center">${transaction.sellerFixed}</td>
			  <td align="center">${transaction.offeredFixed}</td>
			  <td align="center">${transaction.companyFixed}</td>
			  <td align="center">${transaction.contractFixed}</td>
			  <td align="center">${transaction.buyer.name}</td>
			  <td align="center">${transaction.seller.name}</td>
			  <td align="center">${transaction.company.name}</td>
			  <td align="center">${transaction.offer.id}</td>
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