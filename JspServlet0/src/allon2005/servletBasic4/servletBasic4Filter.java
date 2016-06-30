package allon2005.servletBasic4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;

/**
 * Servlet Filter implementation class servletBasic4Filter
 */
@WebFilter(description = "servlet filter", urlPatterns = { "/ServletBasic3" },   //the url pattern is for another servlet!!! (see the bottom notes!)
initParams = @WebInitParam(name="userName", value="John Smith"))  // it is annotated as @WebFilter, similar to @WebServlet, will be created by servlet container during initializaiton

public class servletBasic4Filter implements Filter {
	private String userName;

    /**
     * Default constructor. 
     */
    public servletBasic4Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter writer = response.getWriter();
		String userIp = request.getRemoteAddr();
		writer.println("Welcome ! " + userName + ". Your IP is : " + userIp);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		userName = fConfig.getInitParameter("userName");
		
	}

}

/*1.Filter interface has three methods: init(..), destroy() and doFilter(..). We can implemented as needed
 *
 *2. The url pattern (urlPatterns = { "/ServletBasic3" }) indicate that this filter is for the servlet requested by "/ServletBaisc3". 
 *This is a filter class. It is not a servlet by itself. However, when url request is "/ServletBasic3", this filter will be initialized first before the "ServletBasic3". 
 *That is how the filter works. If the logic inside the filter does not match. We can re-route or send error message back to client.
 *
 *By running the "/ServletBasic3", the result is:
 *"Welcome ! John Smith. Your IP is : 0:0:0:0:0:0:0:1 this is the initial value from annotation : welcome to Mars! this is an override of init(). null "
 *
 */
