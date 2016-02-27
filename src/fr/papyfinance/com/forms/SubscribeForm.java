package fr.papyfinance.com.forms;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.RoleDao;
import fr.papyfinance.com.resources.Util;

public class SubscribeForm {
	private RoleDao roleDao;
	
	public SubscribeForm() {
		roleDao = new RoleDao();
	}

	public User getUser(HttpServletRequest request) {
		User user = new User();
		user.setLname(Util.getInputValue(request, "lname"));
		user.setFname(Util.getInputValue(request, "fname"));
		user.setEmail(Util.getInputValue(request, "email"));
		user.setLogin(Util.getInputValue(request, "login"));
		user.setPassword(User.encrypt(Util.getInputValue(request, "password")));
		user.setRole(roleDao.getByName("Investisseur"));
		user.setConfirmed(true);

		return user;
	}
}
