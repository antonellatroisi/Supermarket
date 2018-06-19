package it.dstech.Supermarket.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.Supermarket.model.Storico;
import it.dstech.Supermarket.service.auth.StoricoService;

@RestController
@RequestMapping ("/storico")
public class StoricoCtrl {
	
	@Autowired
	private StoricoService serviceStorico;
	
	@PostMapping
	public Storico create (@RequestBody Storico storico) {
		return serviceStorico.create(storico);
	}
	@GetMapping
	public List<Storico> findByUser (@RequestParam ("id") Integer id) {
		return serviceStorico.findByUser_id(id);
	}

}
