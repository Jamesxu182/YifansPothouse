package com.james.core.library.service.db.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.james.core.library.model.Authority;
import com.james.core.library.model.User;
import com.james.core.library.model.type.AuthorityType;
import com.james.core.library.repository.AuthorityRepository;
import com.james.core.library.repository.UserRepository;
import com.james.core.library.service.db.UserDatabaseService;

@Service
@ComponentScan(basePackages = {
	"com.james.core.library.repository"
})
public class DefaultUserDatabaseService implements UserDatabaseService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User doesn't exist");
		}
		
		return user;
	}
	
	@Override
	public void registerNewUser(User newUser) {
		Authority readAuthority = authorityRepository.findByAuthority(AuthorityType.READ_AUTHORITY);
		Authority writeAuthority = authorityRepository.findByAuthority(AuthorityType.WRITE_AUTHORITY);
		
		if(readAuthority != null && writeAuthority != null) {
			newUser.addAuthority(readAuthority);
			newUser.addAuthority(writeAuthority);
		}
		
		userRepository.save(newUser);
	}
}
