package it.dstech.Supermarket.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.dstech.Supermarket.model.Categoria;
import it.dstech.Supermarket.model.Prodotto;

public interface IProdottoRepository extends CrudRepository<Prodotto, Integer>{

	List<Prodotto> findByCategoria (Categoria categoria);
}
