package it.dstech.Supermarket.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import it.dstech.Supermarket.model.Categoria;
import it.dstech.Supermarket.model.Prodotto;
import it.dstech.Supermarket.model.User;
import it.dstech.Supermarket.repository.IProdottoRepository;
import it.dstech.Supermarket.repository.IUserRepository;

@Service
public class ProdottoService {

	@Autowired
	private IProdottoRepository dao;
	
	@Autowired
	private StoricoService service;
	
	@Autowired
	private IUserRepository daoUser;
	
	@Autowired
	private CartaCreditoService cartaService;
	private UserService serviceUser;
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
	
	public Iterable<Prodotto> prodottiPerCategoria (Categoria categoria){
		List<Prodotto> listaProdotti = dao.findByCategoria(categoria);
		return listaProdotti;
	}
	public void acquistaProdotto (String numeroCarta, String cvv, int idProdotto) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User utente = daoUser.findByUsername(auth.getName());
	Prodotto prodottoTrovato = dao.findOne(idProdotto);
	daoUser.findByListaCarteCredito(numeroCarta);
	//if (prodottoTrovato.getId() != null) {
		//if (prodottoTrovato.getQuantitaDisponibile() > 0 ) {
			//for (int i= 0; i < utente.getListaCarteCredito().size(); i++) {
				//if (utente.getListaCarteCredito().get(i).getNumero() == numeroCarta) {
					//if (utente.getListaCarteCredito().get(i).getCvv() == cvv) {
						//if (cartaService.findByNumero(numeroCarta).getCredito() >= prodottoTrovato.getPrezzoUnitario()) {
							//cartaService.findByNumero(numeroCarta).setCredito(cartaService.findByNumero(numeroCarta).getCredito() - prodottoTrovato.getPrezzoUnitario());
							// dao.findByListaProdotto(idProdotto).getListaProdotto().add(prodottoTrovato);
			
	}
	//dao.save(utente);
	
	public void acquistoProdotti(String numeroCarta, String cvv, ArrayList<Integer> idProdotti ) throws Exception{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = serviceUser.findByUsername(auth.getName());
		for (Integer id : idProdotti) {
			Prodotto prodotto = dao.findOne(id);
			if(id != null) {
				for(int i = 0; i < user.getListaCarteCredito().size(); i++) {
					if(user.getListaCarteCredito().get(i).getNumero().equals(numeroCarta) && user.getListaCarteCredito().get(i).getCvv().equals(cvv)) {
						if(user.getListaCarteCredito().get(i).getCredito()>= prodotto.getPrezzoUnitario()) {
							prodotto.setQuantitaDisponibile(prodotto.getQuantitaDisponibile()-1);
							user.getListaCarteCredito().get(i).setCredito(user.getListaCarteCredito().get(i).getCredito() - (prodotto.getPrezzoUnitario()));
							//ragazzi, manca aggiungere questa transazione allo storico...
							
							serviceUser.save(user);
						}else {
							throw new Exception ("Insuficient credit");
						}
					}else {
						throw new Exception ("Card not found");
					}
				}
			}else {
				throw new Exception ("Product not found");
			}
		}
	}
}
		
