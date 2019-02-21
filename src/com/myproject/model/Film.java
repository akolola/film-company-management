package com.myproject.model;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Film {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	protected Long id;
	//@Persistent
	//protected String name;
	@Persistent
	protected String genre;
	@Persistent
	protected String description;
	@Persistent
	protected Integer minutes;
	@Persistent
	protected String name;
	
	
	@Persistent
	protected List<Long> contractIds;
	
	@NotPersistent
	protected List<Contract> contracts;

	public Long getId() {
		return id;
	}

	public void setId(Long ida) {
		id = ida;
	}

	//public String getName() {
	//	return name;
	//}

	//public void setName(String name) {
	//	this.name = name;
	//}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public List<Long> getContractIds() {
		return contractIds;
	}

	public void setContractIds(List<Long> contractIds) {
		this.contractIds = contractIds;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	public void deleteContract(Long id) {
		contractIds.remove(id);
	}
	
	public void addContract(Long id) {
		contractIds.add(id);
	}

}
