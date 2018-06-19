package it.dstech.Supermarket.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.Supermarket.model.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	
	User findByListaCarteCredito (String numeroCarta);

}
