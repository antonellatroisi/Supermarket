package it.dstech.Supermarket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.Supermarket.model.CartaCredito;
import it.dstech.Supermarket.service.auth.CartaCreditoService;

@RestController
@RequestMapping ("/cartacredito")
public class CartaCreditoCtrl {

	@Autowired
	private CartaCreditoService cartaCreditoService;
	
	@GetMapping("/{id}")
	public CartaCredito findOne (@PathVariable int id) throws Exception {
		return cartaCreditoService.findOne(id);
	}
	@GetMapping("/findAll")
	public Iterable <CartaCredito> findAll() {
		return cartaCreditoService.findAll();
}
	@PostMapping("/create")
	public CartaCredito create (@RequestBody CartaCredito cartaCredito) {
		return cartaCreditoService.create(cartaCredito);
	}
	@PutMapping("/update")
	public CartaCredito update (@RequestBody CartaCredito cartaCreditoInput) throws Exception {
		return cartaCreditoService.update(cartaCreditoInput);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteOne (@PathVariable int id) {
		cartaCreditoService.deleteOne(id);
	}
}
