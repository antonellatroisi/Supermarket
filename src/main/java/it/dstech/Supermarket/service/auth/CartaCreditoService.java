package it.dstech.Supermarket.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.dstech.Supermarket.model.CartaCredito;
import it.dstech.Supermarket.repository.ICartaCreditoRepository;

@Service
public class CartaCreditoService {

	@Autowired
	private ICartaCreditoRepository dao;

	public CartaCredito findOne (Integer idCartaCredito) throws Exception {
		return dao.findById(idCartaCredito).orElseThrow(()-> new Exception());
	}
	public Iterable <CartaCredito> findAll() {
		return dao.findAll();
	}
	public CartaCredito create (CartaCredito cartaCredito) {
		return dao.save(cartaCredito);
	}
	public CartaCredito update (CartaCredito cartaCreditoInput) throws Exception {
		CartaCredito cartaCreditoDb = findOne(cartaCreditoInput.getId());
		cartaCreditoDb.setCvv(cartaCreditoInput.getCvv());
		cartaCreditoDb.setCredito(cartaCreditoInput.getCredito());
		cartaCreditoDb.setNumero(cartaCreditoInput.getNumero());
		cartaCreditoDb.setScadenza(cartaCreditoInput.getScadenza());
		return dao.save(cartaCreditoDb);
	}
	public void deleteOne (Integer id) {
		dao.deleteById(id);
	}
	public CartaCredito findByNumero(String numeroCarta) {
		return dao.findByNumero(numeroCarta);
	}
}
