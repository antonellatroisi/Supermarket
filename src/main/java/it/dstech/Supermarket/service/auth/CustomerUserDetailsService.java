package it.dstech.Supermarket.service.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.Supermarket.model.User;





@Service
public class CustomerUserDetailsService implements UserDetailsService {

	private static final Logger logger = java.util.logging.Logger.getLogger(CustomerUserDetailsService.class.getName());
	
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		logger.info("User: " + username);
		if (user == null) {
			logger.info ("User not found");
			throw new UsernameNotFoundException ("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, getGrantedAuthorities(user));
	}
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority ("" + user.getUserProfileType()));
		
		logger.info("Authorities: " + authorities);
		return authorities;
	}
}
