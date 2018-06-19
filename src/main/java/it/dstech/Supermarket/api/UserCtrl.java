package it.dstech.Supermarket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.dstech.Supermarket.model.User;
import it.dstech.Supermarket.service.auth.AuthService;
import it.dstech.Supermarket.service.auth.UserService;



@RestController
@RequestMapping("/user")
public class UserCtrl {
	@Autowired
	UserService userService;

	@Autowired
	AuthService serviceAuth;

	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/login")
	public UserDetails authenticate(@RequestBody User user) throws Exception{
		return serviceAuth.authenticate(user);
	}

	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.create(user);
	}
	@PutMapping("/update")
	public User update(@RequestBody User user) {
		return userService.update(user);
	}
	@GetMapping
	public User findOne(Integer id) {
		return userService.findOne(id);
	}
	@GetMapping
	public Iterable<User> findAll(){
		return userService.findAll();
	}
	@GetMapping
	public User findByUsername(String username) {
		return userService.findByUsername(username);
	}
	@DeleteMapping
	public void delete(Integer id) {
		userService.delete(id);
	}
}
