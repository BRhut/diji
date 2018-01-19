package fr.diji.markets.bank.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.diji.markets.bank.DataFactory;
import fr.diji.markets.bank.common.config.SpringConfig;
import fr.diji.markets.bank.persistance.entities.Account;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WithdrawServiceTests {
	@Autowired WithdrawService withdrawService;
	
	

	@Test
	public void withdraw() throws Exception {
		// Arrange
		Mockito.when(withdrawService.getSecurityContext().getAuthenticatedClient()).thenReturn(DataFactory.getClient());
		double withdrawAmount = 10.00;
		double expectedAmount = 90.00;
		String accountId = "ACC01";

		// Act
		Account account = withdrawService.withdraw(accountId, withdrawAmount);

		// Assert
		assertEquals(expectedAmount, account.getBalance(), 0);
	}
	
	@Test
	public void withdrawOnCheckingAccount() throws Exception {
		// Arrange
		Mockito.when(withdrawService.getSecurityContext().getAuthenticatedClient()).thenReturn(DataFactory.getClient());
		double withdrawAmount = 10.00;
		double expectedAmount = 90.00;
		String accountId = null;

		// Act
		Account account = withdrawService.withdraw(accountId, withdrawAmount);

		// Assert
		assertEquals(expectedAmount, account.getBalance(), 0);
	}
}
