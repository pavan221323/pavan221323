package myproject;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class gettingdatafromxml1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletConfig config=getServletConfig();
		String pwd=config.getInitParameter("password");
		
		res.getWriter().print("password:"+pwd);
		
	}

}
