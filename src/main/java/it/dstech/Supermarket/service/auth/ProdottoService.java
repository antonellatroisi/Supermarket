package it.dstech.Supermarket.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.Supermarket.model.Prodotto;
import it.dstech.Supermarket.repository.IProdottoRepository;

@Service
public class ProdottoService {

	@Autowired
	private IProdottoRepository dao;
	
	@Autowired
	private StoricoService service;
	
	public Iterable<Prodotto> salvaProdotto (ArrayList<Prodotto> listaProdotti){
		return dao.save(listaProdotti);
	}
	
	public Prodotto getById(int id) {
		return dao.findOne(id);
	}

	public Iterable<Prodotto> findAll(){
		return dao.findAll();
	}
	
	public Iterable<Prodotto> prodottiDisponibili(){
		List<Prodotto> listaProdotti = (List<Prodotto>) dao.findAll();
		List<Prodotto> listaProdDisponibili = new ArrayList<>();
		for(Prodotto prodotto : listaProdotti) {
			if(prodotto.getQuantitaDisponibile() >0) {
				listaProdDisponibili.add(prodotto);
			}
		}
		return listaProdDisponibili;
	}
	
	public Iterable<Prodotto> prodottiPerCategoria (String categoria){
		List<Prodotto> listaProdotti = dao.findByCategoria(categoria);
		return listaProdotti;
	}
	
	
}
