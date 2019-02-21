package com.myproject.view;

import java.io.IOException;

import javax.servlet.http.*;

import com.myproject.model.Film;
import com.myproject.service.FilmService;

@SuppressWarnings("serial")
public class NewFilmServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String str = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		resp.getWriter().println(str);
		str = "<html>\n<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Create film</title></head>";
		resp.getWriter().println(str);
		
		
		Film nAcc = new Film();
		FilmService service = new FilmService();
		
		String genre = req.getParameter("genre");
		nAcc.setGenre(genre);
		String description = req.getParameter("description");
		nAcc.setDescription(description);
		String namef = req.getParameter("name");
		nAcc.setName(namef);
	
		Integer minutes;
		int condition = 1;
		

		try {
			minutes = Integer.valueOf(req.getParameter("minutes"));
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
	    minutes =Integer.valueOf(req.getParameter("minutes"));
		nAcc.setMinutes(minutes);
	    
		Long id = service.createFilm(nAcc);
		id = service.createFilm(nAcc);
		nAcc = service.readFilm(id);
		
	
		resp.getWriter().println(str+"<body>Film with id = " + nAcc.getId()
                + ", name = " + nAcc.getName() + " and email = " + nAcc.getGenre()
                +" and description = "+ nAcc.getDescription()  +" and minutes = "+ nAcc.getMinutes() 
                + " was sucsessufly registred</body></html>");
				
		}

		//resp.sendRedirect("/Register");
	}
}
