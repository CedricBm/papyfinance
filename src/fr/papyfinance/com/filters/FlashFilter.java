package fr.papyfinance.com.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class FlashFilter implements Filter {
	private final List<String> FLASH_ALERTS = Arrays.asList("unauthorized", "unconfirmed");
	private final List<String> FLASH_SUCCESSES = Arrays.asList("connection", "subscribe");
	private final List<String> FLASH_NOTICES = Arrays.asList("already_connected", "logout");

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();

		for (String alert : FLASH_ALERTS) {
			if (session.getAttribute(alert) != null) {
				request.setAttribute("alert", session.getAttribute(alert));
				session.removeAttribute(alert);
			}
		}

		for (String success : FLASH_SUCCESSES) {
			if (session.getAttribute(success) != null) {
				request.setAttribute("success", session.getAttribute(success));
				session.removeAttribute(success);
			}
		}

		for (String notice : FLASH_NOTICES) {
			if (session.getAttribute(notice) != null) {
				request.setAttribute("notice", session.getAttribute(notice));
				session.removeAttribute(notice);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
