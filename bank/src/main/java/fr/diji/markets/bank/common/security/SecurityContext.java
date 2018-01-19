package fr.diji.markets.bank.common.security;

import org.springframework.stereotype.Component;

import fr.diji.markets.bank.persistance.entities.Client;

/**
 * Replaces in the exercice a real security context.
 * No real value except for design purposes.
 * 
 * Data are hard coded, else it would mean mocking that class, so not having the method static and then auto wiring it in the service. 
 * Which could be wrong regarding app typology and auth backend. 
 * 
 * @author Mickael
 *
 */
@Component
public class SecurityContext {
	public Client getAuthenticatedClient() {
		return null;
	}
}
