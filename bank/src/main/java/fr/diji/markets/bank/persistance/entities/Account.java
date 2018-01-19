package fr.diji.markets.bank.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	public String id;
	@ManyToOne
	@JoinColumn(name="id_client")
	public Client client;
	public boolean checking;
	private double balance;
	
	
	
	public void withdraw(double withdrawAmount) {
		// TODO call rules engine
		
		balance -= withdrawAmount;
	}
	
	public double getBalance() {
		return balance;
	}
	
}
