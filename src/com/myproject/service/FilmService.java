package com.myproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.myproject.model.Actor;
import com.myproject.model.Contract;
import com.myproject.model.Film;


public class FilmService {
	
	protected PersistenceManager pm = PMF.get().getPersistenceManager();
	
	
	public Long createFilm (Film acc) {
		try {
            if(pm.isClosed()) {throw new Exception();}
         //   acc.setDate(new Date());
			return pm.makePersistent(acc).getId();
        }
		catch(Exception e) {
			pm = PMF.get().getPersistenceManager();
		//	acc.setDate(new Date());
			return pm.makePersistent(acc).getId();
		}
		finally {
            pm.close();
        }
	}
	
	
	public Film readFilm(Long id) {
		try {
			if(pm.isClosed()) {throw new Exception();}
			return (Film) pm.getObjectById(Film.class, id);
		}
		catch(Exception e) {
			pm = PMF.get().getPersistenceManager();
			return (Film) pm.getObjectById(Film.class, id);
		}
		finally {
			pm.close();
		}
	}
		
		
	public void deleteFilm(Long id) {
		if(!pm.isClosed()) {pm.close();}
		pm = PMF.get().getPersistenceManager();
		try {
			Film film = pm.getObjectById(Film.class, id);
			pm.deletePersistent(film);
		}
		finally {
			pm.close();
		}
	}
	
	public void updName(String name, Long id) {
		if(pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		try {
			Film bAcc = pm.getObjectById(Film.class, id);
			bAcc.setName(name);
		}
		finally {
			pm.close();
		}
	}
	
	public void updGenre(String genre, Long id) {
		if(pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		try {
			Film bAcc = pm.getObjectById(Film.class, id);
			bAcc.setGenre(genre);
		}
		finally {
			pm.close();
		}
	}
	
	public void updDescription(String description, Long id) {
		if(pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		try {
			Film bAcc = pm.getObjectById(Film.class, id);
			bAcc.setDescription(description);
		}
		finally {
			pm.close();
		}
	}
		
	
	public void updMinutes(Integer minutes, Long id) {
		if(pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		try {
			Film bAcc = pm.getObjectById(Film.class, id);
			bAcc.setMinutes(minutes);
		}
		finally {
			pm.close();
		}
	}
	
/*	
	public List<Film> getAllFilms() {
		if(!pm.isClosed()) {pm.close();}
		pm = PMF.get().getPersistenceManager();
		try {
			String quer = "select from " + Film.class.getName();
			return (List<Film>) pm.newQuery(quer).execute();
		}
		finally {
		
		}
	}
*/
	
	public List<Film> getAllFilms() {
		pm = PMF.get().getPersistenceManager();
		List<Film> films = new ArrayList<Film>();
		try {
			String quer = "select id from " + Film.class.getName();
			List<Long> ids =  (List<Long>) pm.newQuery(quer).execute();
			for(Long i:ids) {
				films.add(pm.getObjectById(Film.class, i));
			}
			return films;
		}
		finally {
			pm.close();
		}
	}
	
	public void addContract(Long contractId, Long filmId) {
		pm = PMF.get().getPersistenceManager();
		try {
			Film film = pm.getObjectById(Film.class, filmId);
			film.addContract(contractId);
			Contract contract = pm.getObjectById(Contract.class, contractId);
			if(contract.getFilmId() != null) {
				pm.getObjectById(Film.class, contract.getFilmId()).deleteContract(contractId);
			}
			contract.setFilmId(filmId);
		}
		finally {
			pm.close();
		}
	}
	

}
