package com.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sample.config.IdentityUserDetails;
import com.sample.entity.Users;
import com.sample.repository.UserCredentialRepository;

public class IdentityUserDeatailService implements UserDetailsService{

	@Autowired
	private UserCredentialRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<Users> credential=	repository.findByName(username);
		return credential.map(IdentityUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not found"));
	}

}
