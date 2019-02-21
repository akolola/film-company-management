package com.myproject.view;

import java.io.IOException;

import javax.servlet.http.*;

import com.myproject.model.Actor;
import com.myproject.model.Contract;
import com.myproject.service.ActorService;
import com.myproject.service.ContractService;

@SuppressWarnings("serial")
public class NewContractServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String str = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		resp.getWriter().println(str);
		str = "<html>\n<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Create contract</title></head>";
		resp.getWriter().println(str);
		
		
		
		Contract nAcc = new Contract();
		ContractService service = new ContractService();
		//Actor nAcc2 = new Actor();
		//ActorService service2 = new ActorService();
	
		Long salary;
		Long actorId;
		Long filmId;
		int condition = 1;
		
		
		
		try {
			salary = Long.valueOf(req.getParameter("salary"));
		}
		catch(NumberFormatException e) {
			condition = 0;
		}
		
		try {
			actorId = Long.valueOf(req.getParameter("actorId"));
		}
		catch(NumberFormatException e) {
			condition = 0;
		}
		
		try {
			filmId = Long.valueOf(req.getParameter("filmId"));
		}
		catch(NumberFormatException e) {
			condition = 0;
		}
		
		if(condition == 0) {
			resp.getWriter().println( str + "<body>"
					+"Inputed data has no numbers"
					+"</body></html>");
			
		}
		else {
		salary =Long.valueOf(req.getParameter("salary"));
		nAcc.setSalary(salary);
		Long id = service.createContract(nAcc);
		id = service.createContract(nAcc);
		nAcc = service.readContract(id);
	
		actorId = Long.valueOf(req.getParameter("actorId"));
		service.updActor(actorId ,id);
		filmId = Long.valueOf(req.getParameter("filmId"));
		service.updFilm(filmId ,id);
		/*
		nAcc2 = service2.readActor(actorId);
		*/
		resp.getWriter().println(str+"<body>Contract with id = " + nAcc.getId()
				                 + ", salary = " + nAcc.getSalary()
				                 +" and date = "+ nAcc.getDateBegin()
				                 + " was sucsessufly registred</body></html>");
				
		}
		//resp.sendRedirect("/Register");
	}
}
