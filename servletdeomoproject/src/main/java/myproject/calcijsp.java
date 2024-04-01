package myproject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/hiiii")

public class calcijsp extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a=Integer.parseInt(req.getParameter("a"));
		int b=Integer.parseInt(req.getParameter("b"));
		
		req.setAttribute("a", a);
		req.setAttribute("b", b);
		
		RequestDispatcher rq=req.getRequestDispatcher("calc.jsp");
		rq.include(req, resp);
	}
	

}
