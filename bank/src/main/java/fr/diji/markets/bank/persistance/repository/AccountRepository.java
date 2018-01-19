package fr.diji.markets.bank.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.diji.markets.bank.persistance.entities.Account;
import fr.diji.markets.bank.persistance.entities.Client;

public interface AccountRepository extends JpaRepository<Account, String>{

	@Query("SELECT e FROM Account e WHERE e.client=:client")
	List<Account> findByClient(@Param("client") Client client);

	@Query("SELECT e FROM Account e WHERE e.client=:client AND e.checking=1")
	Account findCheckingAccount(@Param("client") Client client);

}
