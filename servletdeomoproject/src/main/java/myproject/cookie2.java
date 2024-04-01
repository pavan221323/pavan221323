package myproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/homeee")

public class cookie2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie[] c=req.getCookies();
		
		String email=null;
		String password=null;
		
		
		if(c.length>0) {
			for(Cookie c1:c) {
				if(c1.getValue().equals("pavankumarbandla141@gmail.com")) {
					email=c1.getValue();
				}
				else if(c1.getValue().equals("pavan1")) {
					password=c1.getValue();
				}
			}
		}
		
		if(email!=null && password!=null) {
			resp.getWriter().print("homepage");
		}
		else {
			resp.getWriter().print("login or password requires");
		}
	}

}
