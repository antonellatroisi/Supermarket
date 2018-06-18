package it.dstech.Supermarket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.Supermarket.model.CartaCredito;
import it.dstech.Supermarket.service.auth.CartaCreditoService;

@RestController
@RequestMapping ("/cartacredito")
public class CartaCreditoCtrl {

	@Autowired
	private CartaCreditoService cartaCreditoService;
	
	@GetMapping("{id}")
	public CartaCredito findOne (int id) {
		return cartaCreditoService.findOne(id);
	}
	@GetMapping
	public Iterable <CartaCredito> findAll() {
		return cartaCreditoService.findAll();
}
	@PostMapping
	public CartaCredito create (@RequestBody CartaCredito cartaCredito) {
		return cartaCreditoService.create(cartaCredito);
	}
	@PutMapping
	public CartaCredito update (@RequestBody CartaCredito cartaCreditoInput) {
		return cartaCreditoService.update(cartaCreditoInput);
	}
	@DeleteMapping
	public void deleteOne (int id) {
		cartaCreditoService.deleteOne(id);
	}
}
