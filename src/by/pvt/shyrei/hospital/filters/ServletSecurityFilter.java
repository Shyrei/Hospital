package by.pvt.shyrei.hospital.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import by.pvt.shyrei.hospital.command.ClientType;

/**
 * @author Shyrei Uladzimir
 * Filter of user types
 */
@WebFilter(dispatcherTypes = {
DispatcherType.REQUEST,
DispatcherType.FORWARD,
DispatcherType.INCLUDE
}, urlPatterns = { "/jsp/regist.jsp" })
public class ServletSecurityFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		ClientType type = (ClientType) session.getAttribute("userType");
		if (type == ClientType.ADMINISTRATOR) {
			request.getRequestDispatcher("/jsp/mainadmin.jsp").forward(request, response);
	
		} if (type == ClientType.USER) {
			request.getRequestDispatcher("/jsp/mainuser.jsp").forward(request, response);
	
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}
}
