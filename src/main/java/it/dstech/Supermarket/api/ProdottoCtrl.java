package it.dstech.Supermarket.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.Supermarket.model.Categoria;
import it.dstech.Supermarket.model.Prodotto;
import it.dstech.Supermarket.model.Storico;
import it.dstech.Supermarket.service.auth.ProdottoService;

@RestController
@RequestMapping("/prodotto")
public class ProdottoCtrl {

	@Autowired
	private ProdottoService service;
	
	@PostMapping("createList")
	public Iterable<Prodotto> salvaProdotto (@RequestBody ArrayList<Prodotto> listaProdotti){
		return service.salvaProdotto(listaProdotti);
	}
	
	@GetMapping("{id}")
	public Prodotto getById(@PathVariable int id) throws Exception {
		return service.getById(id);
	}

	@GetMapping("/findAll")
	public Iterable<Prodotto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/prodottiDisponibili")
	public Iterable<Prodotto> prodottiDisponibili(){
		return service.prodottiDisponibili();
	}
	
	@GetMapping("/findByCategoria")
	public Iterable<Prodotto> prodottiPerCategoria (@RequestHeader ("categoria") Categoria categoria){
		return service.prodottiPerCategoria(categoria);
	}
	@GetMapping("/acquisto")
	public Storico acquista (@RequestBody List<Prodotto> listaProdotti, @RequestParam ("idCartaCredito") Integer idCartaCredito) throws Exception {
		return service.acquista(listaProdotti, idCartaCredito);
	}
	
}
