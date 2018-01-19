package fr.diji.markets.bank;

import fr.diji.markets.bank.persistance.entities.Client;

public class DataFactory {
	public static Client getClient() {
		return new Client(1, "jean-pierre", "KASTOR");
	}
}
