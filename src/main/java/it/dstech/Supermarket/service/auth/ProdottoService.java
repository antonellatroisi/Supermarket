package it.dstech.Supermarket.service.auth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import it.dstech.Supermarket.model.CartaCredito;
import it.dstech.Supermarket.model.Categoria;
import it.dstech.Supermarket.model.Prodotto;
import it.dstech.Supermarket.model.Storico;
import it.dstech.Supermarket.model.User;
import it.dstech.Supermarket.repository.IProdottoRepository;
import it.dstech.Supermarket.repository.IUserRepository;

@Service
public class ProdottoService {

	@Autowired
	private IProdottoRepository dao;

	@Autowired
	private CartaCreditoService cartaCreditoService;

	@Autowired
	private IUserRepository daoUser;

	@Autowired
	private UserService serviceUser;
	@Autowired
	private StoricoService storicoService;

	public Iterable<Prodotto> salvaProdotto (ArrayList<Prodotto> listaProdotti){
		return dao.save(listaProdotti);
	}
	public Prodotto  getById(int id) {
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
	public Prodotto update (Prodotto prodottoInInput) {
		Prodotto prodottoDb = getById(prodottoInInput.getId());
		prodottoDb.setNome(prodottoInInput.getNome());
		prodottoDb.setMarca(prodottoInInput.getMarca());
		prodottoDb.setDataDiScadenza(prodottoInInput.getDataDiScadenza());
		prodottoDb.setCategoria(prodottoInInput.getCategoria());
		prodottoDb.setQuantitaDisponibile(prodottoInInput.getQuantitaDisponibile());
		prodottoDb.setUnita(prodottoInInput.getUnita());
		prodottoDb.setPrezzoUnitario(prodottoInInput.getPrezzoUnitario());
		prodottoDb.setPrezzoIvato(prodottoInInput.getPrezzoIvato());
		prodottoDb.setOfferta(prodottoInInput.getOfferta());
		return dao.save(prodottoDb);
	}

	public Storico acquista (List<Prodotto> listaProdotti, Integer idCartaCredito) {
		for(Prodotto p : listaProdotti) {
			if(p.getQuantitaDisponibile() < 1) {
				return null;
			}
		}
		Double contoTotale = 0.0;
		for(Prodotto p : listaProdotti) {
			if(p.getOfferta() > 0) {
				contoTotale += (p.getPrezzoIvato() - (p.getPrezzoIvato()*p.getOfferta()/100));
			} else if (p.getDataDiScadenza().isEqual(LocalDate.now().minusDays(3))) {
				contoTotale += (p.getPrezzoIvato() - (p.getPrezzoIvato()*40/100));
			} else {
				contoTotale += p.getPrezzoUnitario();
			}
		}
		CartaCredito carta = cartaCreditoService.findOne(idCartaCredito);

		if(carta.getCredito() < contoTotale) {
			return null; 
		}
		Storico storico = new Storico();
		storico.setListaProdotti(new ArrayList<Prodotto>());
		for(Prodotto p : listaProdotti) {
			p.setQuantitaDisponibile(p.getQuantitaDisponibile()-1);
			storico.getListaProdotti().add(p);
		}
		storico.setTotale(contoTotale);
		storico.setData(LocalDate.now());
		for(Prodotto p : listaProdotti) {
			update(p);
		}
		return storicoService.create(storico);
	}
}

