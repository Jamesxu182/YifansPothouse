package com.james.resource.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableResourceServer
@EnableOAuth2Client
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter  {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/test").authenticated()
				.antMatchers("/user/**").authenticated()
				.anyRequest().permitAll()
			.and()
				.httpBasic();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources
			.tokenServices(remoteTokenServices());
	}
	
	@Bean
	protected RemoteTokenServices remoteTokenServices(){
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		
		remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:7080/auth/oauth/check_token");
		remoteTokenServices.setClientId("web_app");
		remoteTokenServices.setClientSecret("123456");
		remoteTokenServices.setAccessTokenConverter(jwtTokenEnhancer());
		
		return remoteTokenServices;
	}
	
    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
    	DefaultUserAuthenticationConverter userAuthenticationConverter = new DefaultUserAuthenticationConverter();
    	userAuthenticationConverter.setUserDetailsService(userDetailsService);
    	
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setAccessTokenConverter(accessTokenConverter);
        jwtAccessTokenConverter.setSigningKey("123");
        
        return jwtAccessTokenConverter;
    }
}
