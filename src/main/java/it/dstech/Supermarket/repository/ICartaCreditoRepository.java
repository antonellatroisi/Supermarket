package it.dstech.Supermarket.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.Supermarket.model.CartaCredito;

public interface ICartaCreditoRepository extends CrudRepository <CartaCredito, Integer> {

	CartaCredito findByNumero (String numeroCarta);
	
}
