package com.myproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.myproject.model.Actor;
import com.myproject.model.Contract;


public class ActorService {
	
	protected PersistenceManager pm = PMF.get().getPersistenceManager();
	
	
	public Long createActor(Actor acc) {
		try {
            if(pm.isClosed()) {throw new Exception();}
            acc.setDate(new Date());
			return pm.makePersistent(acc).getId();
        }
		catch(Exception e) {
			pm = PMF.get().getPersistenceManager();
			acc.setDate(new Date());
			return pm.makePersistent(acc).getId();
		}
		finally {
            pm.close();
        }
	}
	
	
	public Actor readActor(Long id) {
		try {
			if(pm.isClosed()) {throw new Exception();}
			return (Actor) pm.getObjectById(Actor.class, id);
		}
		catch(Exception e) {
			pm = PMF.get().getPersistenceManager();
			return (Actor) pm.getObjectById(Actor.class, id);
		}
		finally {
			pm.close();
		}
	}
		
		
	public void deleteActor(Long id) {
		if(!pm.isClosed()) {pm.close();}
		pm = PMF.get().getPersistenceManager();
		try {
			Actor account = pm.getObjectById(Actor.class, id);
			pm.deletePersistent(account);
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
			Actor bAcc = pm.getObjectById(Actor.class, id);
			bAcc.setName(name);
		}
		finally {
			pm.close();
		}
	}
	
	public void updEmail(String Email, Long id) {
		if(pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		try {
			Actor bAcc = pm.getObjectById(Actor.class, id);
			bAcc.setEmail(Email);
		}
		finally {
			pm.close();
		}
	}
	
	public void updDate(Date date, Long id) {
		if(pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		try {
			Actor bAcc = pm.getObjectById(Actor.class, id);
			bAcc.setDate(date);
		}
		finally {
			pm.close();
		}
	}
	
	
	public List<Actor> getAllActors() {
		pm = PMF.get().getPersistenceManager();
		List<Actor> actors = new ArrayList<Actor>();
		try {
			String quer = "select id from " + Actor.class.getName();
			List<Long> ids =  (List<Long>) pm.newQuery(quer).execute();
			for(Long i:ids) {
				actors.add(pm.getObjectById(Actor.class, i));
			}
			return actors;
		}
		finally {
			pm.close();
		}
	}
	
	public void addContract(Long contractId, Long actorId) {
		pm = PMF.get().getPersistenceManager();
		try {
			Actor actor = pm.getObjectById(Actor.class, actorId);
			actor.addContract(contractId);
			Contract contract = pm.getObjectById(Contract.class, contractId);
			if(contract.getActorId() != null) {
				pm.getObjectById(Actor.class, contract.getActorId()).deleteContract(contractId);
			}
			contract.setActorId(actorId);
		}
		finally {
			pm.close();
		}
	}

}
