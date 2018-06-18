package it.dstech.Supermarket.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.dstech.Supermarket.model.Storico;

public interface IStoricoRepository extends CrudRepository <Storico, Integer> {

	List<Storico> findByUser_id (Integer id);

}
