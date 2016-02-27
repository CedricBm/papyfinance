package fr.papyfinance.com.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.papyfinance.com.beans.User;

public final class Util {
	public static String getInputValue(HttpServletRequest request, String inputName) {
		String value = request.getParameter(inputName);
		if (value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value.trim();
		}
	}
	
	public static void login(User u, HttpSession session) {
		session.setAttribute("user", u);
	}
	
	public static void logout(HttpSession session) {
		session.invalidate();
	}
	
	public static User currentUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
}
