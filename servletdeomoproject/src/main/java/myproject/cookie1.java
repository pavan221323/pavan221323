package myproject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logined")
public class cookie1 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=req.getParameter("email");
		String password=req.getParameter("txt");
		
		Cookie c1=new Cookie("email",email);
		Cookie c2=new Cookie("password",password);
		
		resp.addCookie(c2);
		resp.addCookie(c1);
		
		RequestDispatcher rq=req.getRequestDispatcher("homeee");
		rq.include(req, resp);
		
	}

}
