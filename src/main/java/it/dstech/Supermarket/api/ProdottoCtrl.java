package it.dstech.Supermarket.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.Supermarket.model.Prodotto;
import it.dstech.Supermarket.service.auth.ProdottoService;

@RestController
@RequestMapping("/prodotto")
public class ProdottoCtrl {

	@Autowired
	private ProdottoService service;
	
	@PostMapping("/prodotto")
	public Iterable<Prodotto> salvaProdotto (@RequestBody ArrayList<Prodotto> listaProdotti){
		return service.salvaProdotto(listaProdotti);
	}
	
	@GetMapping("/prodotto/{id}")
	public Prodotto getById(int id) {
		return service.getById(id);
	}

	@GetMapping("/prodotto")
	public Iterable<Prodotto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/prodotto/disponibili")
	public Iterable<Prodotto> prodottiDisponibili(){
		return service.prodottiDisponibili();
	}
	
	@GetMapping("/prodotto/categoria")
	public Iterable<Prodotto> prodottiPerCategoria (@RequestHeader ("categoria") String categoria){
		return service.prodottiPerCategoria(categoria);
	}
}
