package com.myproject.view;

import java.io.IOException;

import javax.servlet.http.*;

import com.myproject.model.Actor;
import com.myproject.service.ActorService;

@SuppressWarnings("serial")
public class NewActorServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String str = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		resp.getWriter().println(str);
		str = "<html>\n<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Create actor</title></head>";
		resp.getWriter().println(str);
		Actor nAcc = new Actor();
		ActorService service = new ActorService();
		
		String name = req.getParameter("name");
		nAcc.setName(name);
		String email = req.getParameter("email");
		nAcc.setEmail(email);
		
		Long id = service.createActor(nAcc);
		
		id = service.createActor(nAcc);
		nAcc = service.readActor(id);

		resp.getWriter().println(str+"<body>Actor with id = " + nAcc.getId()
				                 + ", name = " + nAcc.getName() + " and email = " + nAcc.getEmail()
				                 +" and date = "+ nAcc.getDate()
				                 + " was sucsessufly registred" +
				                 "</body></html>");
		//resp.sendRedirect("/Register");
	}
}
