package com.james.resource.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
public class JwtAccessTokenConverterConfiguration implements JwtAccessTokenConverterConfigurer {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public void configure(JwtAccessTokenConverter converter) {
    	DefaultUserAuthenticationConverter userAuthenticationConverter = new DefaultUserAuthenticationConverter();
    	userAuthenticationConverter.setUserDetailsService(userDetailsService);
    	
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        
        converter.setAccessTokenConverter(accessTokenConverter);
        converter.setSigningKey("123");
	}
}
