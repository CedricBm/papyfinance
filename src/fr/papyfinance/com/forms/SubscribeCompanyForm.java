package fr.papyfinance.com.forms;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.RoleDao;
import fr.papyfinance.com.resources.Util;

public class SubscribeCompanyForm {
	private RoleDao roleDao;
	private CompanyDao companyDao;
	
	public SubscribeCompanyForm() {
		roleDao = new RoleDao();
		companyDao = new CompanyDao();
	}

	public User getUser(HttpServletRequest request) {
		User user = new User();
		String id_company;
		user.setLname(Util.getInputValue(request, "lname"));
		user.setFname(Util.getInputValue(request, "fname"));
		user.setEmail(Util.getInputValue(request, "email"));
		id_company=Util.getInputValue(request, "company");
		if(id_company!=null)
		{

			user.setCompany(companyDao.getById(Integer.parseInt(id_company)));
		}
		user.setRole(roleDao.getByName("Membre société"));
		user.setConfirmed(false);

		return user;
	}
}
