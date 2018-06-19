package it.dstech.Supermarket.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.Supermarket.model.User;
import it.dstech.Supermarket.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	IUserRepository dao;

	public User create(User user) {
		return dao.save(user);
	}

	public User findOne(Integer id) throws Exception {
		return dao.findById(id).orElseThrow(() -> new Exception());
	}

	public Iterable<User> findAll(){
		return dao.findAll();
	}

	public User update(User user) throws Exception {
		User userDb=findOne(user.getId());
		userDb.setPassword(user.getPassword());
		userDb.setUsername(user.getUsername());
		userDb.setTelefono(user.getTelefono());
		userDb.setVia(user.getVia());
		userDb.setCap(user.getCap());
		userDb.setCitta(user.getCitta());
		userDb.setProvincia(user.getProvincia());
		userDb.setUserProfileType(user.getUserProfileType());
		return dao.save(userDb);
	}

	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
