package fr.diji.markets.bank.common.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import fr.diji.markets.bank.common.security.SecurityContext;

@Profile("test")
@Configuration
public class SpringConfig {
	@Bean
    @Primary
    public SecurityContext securityContext() {
        return Mockito.mock(SecurityContext.class);
    }
}
