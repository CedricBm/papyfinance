<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin-search pageTitle="Liste des membres société">
	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<div class="row center">
				<div class="col s12 m8">
					<div class="row center">
						<c:choose>
							<c:when test="${empty _LISTE_USERS }">
								<p>Liste des membre société est vide !!</p>
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

									<c:forEach var="user" items="${_LISTE_USERS}">
										<tbody>
											<tr>
												<td align="center">${user.id}</td>
												<td align="center">${user.confirmed}</td>
												<td align="center">${user.email}</td>
												<td align="center">${user.fname}</td>
												<td align="center">${user.lname}</td>
												<td align="center">${user.login}</td>
												<td align="center">${user.company.name}</td>
												<td align="center"><c:choose>
														<c:when test="${user.isConfirmed()}">
															<form class="col s12 hoverable" method="post"
																action="/PapyFinance/admin/desactivate">
																<input id="email" type="text" name="email"
																	value="${user.getEmail()}" style="display:none"/>
																<button class="waves-effect waves-light btn"
																	type="submit">DESACTIVER</button>
															</form>
														</c:when>
														<c:otherwise>
															<form class="col s12 hoverable" method="post"
																action="/PapyFinance/admin/activate">
																<input id="email" type="text" name="email"
																	value="${user.getEmail()}" style="display:none"/>
																<button class="waves-effect waves-light btn"
																	type="submit">ACTIVER</button>
															</form>
														</c:otherwise>
													</c:choose></td>
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
</layout:admin-search>