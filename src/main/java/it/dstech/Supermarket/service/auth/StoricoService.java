package it.dstech.Supermarket.service.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.Supermarket.model.Storico;
import it.dstech.Supermarket.repository.IStoricoRepository;

@Service 
public class StoricoService {

	@Autowired
	IStoricoRepository dao;


	public List<Storico> findByUser_id(Integer id) {
		return dao.findByUser_id(id);
	}
}