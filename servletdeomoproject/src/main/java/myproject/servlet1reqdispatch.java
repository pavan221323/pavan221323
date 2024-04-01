package myproject;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet1reqdispatch extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("username");
		
		req.setAttribute("key", name);
		res.getWriter().print("hi"+name);
		
		RequestDispatcher rq=req.getRequestDispatcher("bye");
		rq.forward(req, res);
//        rq.forward(req, res);
		
	}

}
