package com.myproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.myproject.model.Actor;
import com.myproject.model.Contract;
import com.myproject.model.Film;


public class ContractService {
	
	protected PersistenceManager pm = PMF.get().getPersistenceManager();
	
	
	public Long createContract (Contract acc) {
		try {
            if(pm.isClosed()) {throw new Exception();}
            acc.setDateBegin(new Date());
			return pm.makePersistent(acc).getId();
        }
		catch(Exception e) {
			pm = PMF.get().getPersistenceManager();
			acc.setDateBegin(new Date());
			return pm.makePersistent(acc).getId();
		}
		finally {
            pm.close();
        }
	}
	
	
	public Contract readContract(Long id) {
		try {
			if(pm.isClosed()) {throw new Exception();}
			return (Contract) pm.getObjectById(Contract.class, id);
		}
		catch(Exception e) {
			pm = PMF.get().getPersistenceManager();
			return (Contract) pm.getObjectById(Contract.class, id);
		}
		finally {
			pm.close();
		}
	}
		
		
	public void deleteContract(Long id) {
		if(!pm.isClosed()) {pm.close();}
		pm = PMF.get().getPersistenceManager();
		try {
			Contract contract = pm.getObjectById(Contract.class, id);
			pm.getObjectById(Actor.class, contract.getActorId()).deleteContract(id);
			pm.getObjectById(Film.class, contract.getFilmId()).deleteContract(id);
			pm.deletePersistent(contract);
		}
		finally {
			pm.close();
		}
	}
	
	
	public void updSalary(Long salary, Long id) {
		if(pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		try {
			Contract bAcc = pm.getObjectById(Contract.class, id);
			bAcc.setSalary(salary);
		}
		finally {
			pm.close();
		}
	}
	

	
	public List<Contract> getAllContracts() {
		pm = PMF.get().getPersistenceManager();
		List<Contract> contracts = new ArrayList<Contract>();
		try {
			String quer = "select id from " + Contract.class.getName();
			List<Long> ids =  (List<Long>) pm.newQuery(quer).execute();
			for(Long i:ids) {
				contracts.add(pm.getObjectById(Contract.class, i));
			}
			return contracts;
		}
		finally {
			pm.close();
		}
	}
	
	
	public void updActor(Long actorId, Long contractId) {
		pm = PMF.get().getPersistenceManager();
		try {
			Contract contract = pm.getObjectById(Contract.class, contractId);
			if(contract.getActorId() != null) {
				pm.getObjectById(Actor.class, contract.getActorId()).deleteContract(contractId);
			}
			contract.setActorId(actorId);
			Actor actor = pm.getObjectById(Actor.class, actorId);
			actor.addContract(contractId);
		}
		finally {
			pm.close();
		}
	}
	
	public void updFilm(Long filmId, Long contractId) {
		pm = PMF.get().getPersistenceManager();
		try {
			Contract contract = pm.getObjectById(Contract.class, contractId);
			if(contract.getFilmId() != null) {
				pm.getObjectById(Film.class, contract.getFilmId()).deleteContract(contractId);
			}
			contract.setFilmId(filmId);
			Film film = pm.getObjectById(Film.class, filmId);
			film.addContract(contractId);
		}
		finally {
			pm.close();
		}
	}

}