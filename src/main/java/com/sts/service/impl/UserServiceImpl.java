package com.sts.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sts.entity.Role;
import com.sts.entity.User;
import com.sts.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		if(optionalUser.isEmpty())
			throw new UsernameNotFoundException("Invalid username or password");
		User user= optionalUser.get();
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),getAuthorities(user));
	}

	private Set<GrantedAuthority> getAuthorities(User user){
		Set<Role> roleSet = user.getRoles();
		return roleSet.stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getName().toString().toUpperCase())).collect(Collectors.toSet());
	}
}
