package fr.diji.markets.bank.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int id;
	public String firstname;
	public String lastname;
	
	public Client() {
	}
	
	public Client(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
}
