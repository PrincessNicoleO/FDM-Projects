package com.fdmgroup.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DOG TABLE")
public class Dog {
	@Id
	@Column(name = "DOG ID", nullable = false, updatable = false)
	private int id;
	@Column(name = "DOG NAME", nullable = false, updatable = false)
	private String name;
	@Column(name = "DOG BREED", nullable = false)
	private String breed;
	@Column(name = "IS_NEUTERED", nullable = false)
	private boolean isNeutered;
	
	@Transient
	private boolean isSleeping;
	Dog() {} 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isNeutered() {
		return isNeutered;
	}

	public void setNeutered(boolean isNeutered) {
		this.isNeutered = isNeutered;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	public Dog(int id, String name, String breed, boolean isNeutered) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.isNeutered = isNeutered;
	}
	
	
	
	

}
