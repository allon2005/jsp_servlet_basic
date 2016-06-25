package allon2005.servletBasic0;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * servlet using xml configuration
 */
public class xmlSevlet0 extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.print("the protocal of this url request is:  " + req.getProtocol());
		resp.getWriter().append("the protocal of this url request is:  " + req.getProtocol());
	}
	
	

}
