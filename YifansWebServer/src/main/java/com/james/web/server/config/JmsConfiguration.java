package com.james.web.server.config;

import javax.jms.ConnectionFactory;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiLocatorDelegate;

@Configuration
public class JmsConfiguration {
	@Bean
	ConnectionFactory connectionFactory() {
		JndiLocatorDelegate jndiLocatorDelegate = JndiLocatorDelegate.createDefaultResourceRefLocator();
		ConnectionFactory connectionFactory = null;
		
		try {
			connectionFactory = jndiLocatorDelegate.lookup("jms/wmqQueueConnectionFactory", ConnectionFactory.class);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connectionFactory;
	}

}
