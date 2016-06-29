package allon2005.servletBasic1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletBasic2
 * 
 * focus on doGet() and doPost()
 */
@WebServlet(description = "servlet basic1", urlPatterns = { "/servletBasic1" })
public class servletBasic1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		/*String username = request.getParameter("username");  //this will get the value of "username" from the url.  http://localhost:8080/JspServlet0/xmlServlet1?username=allon2005
		writer.println("The username from url by get method is  : " + username);
		*/

		//the following codes can be used soly by "get" method to print parameter/value, and also by "post" to print param/values!!!!
	      Enumeration paramNames = request.getParameterNames();
	      
	      while(paramNames.hasMoreElements()) {
	         String paramName = (String)paramNames.nextElement();
	         writer.print(paramName + " : ");
	         String[] paramValues =
	                request.getParameterValues(paramName);
	         // Read single valued data
	         if (paramValues.length == 1) {
	           String paramValue = paramValues[0];
	           if (paramValue.length() == 0)
	        	   writer.println("No Value");
	           else
	        	   writer.println(paramValue);
	         } else {
	             // Read multiple valued data
	             for(int i=0; i < paramValues.length-1; i++) {
	            	 writer.println(paramValues[i] + ",");
	             }
	             writer.println(paramValues[paramValues.length-1]);
	         }
	      }
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");  //this will get the value of "username" from the "post" method
		String firstName = request.getParameter("firstName");  //if multiple data are posted, we can get each of them from the "request".
		String lastName = request.getParameter("lastName");  
		String address1 = request.getParameter("address1");  
		String address2 = request.getParameter("address2");  
		String city = request.getParameter("city");  
		String state = request.getParameter("state");  
		String zipCode = request.getParameter("zipCode");  
		String[] interestList = request.getParameterValues("interest");  //if certain request item has multiple inputs, need to use this method to return a String[].

		StringBuilder interest = new StringBuilder();
		if(interestList !=null && interestList.length > 0)
		{
			for(String str : interestList)
			{
				interest.append(str + ",");
			}

			interest.deleteCharAt(interest.length()-1);
		}

		writer.println("The register information are: " + "<br>"
				+ "user name : " + userName +"<br>"
				+ "first name : " + firstName +"<br>"
				+ "last name : " + lastName +"<br>"
				+ "address 1 : " + address1 +"<br>"
				+ "address 2 : " + address2 +"<br>"
				+ "city : " + city +"<br>"
				+ "state : " + state +"<br>"
				+ "zip code : " + zipCode +"<br>"
				+ "interest : " + interest.toString());
		
	//// or we should get the param Name and value by code, not hard-coded
	// we will pass the request and response to doGet() to handle it!!!  however, the initial method is "post", so the parameter's value is not visible in the URL
		doGet(request,response);
	}
	
	
	
	

}
