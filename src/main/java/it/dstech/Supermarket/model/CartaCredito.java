package it.dstech.Supermarket.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name = "carta_credito")
public class CartaCredito extends Base {
	@Column (name = "numero", unique = true, nullable = false)
	private String numero;
	@Column (name = "scadenza", unique = false, nullable = false)
	private LocalDate scadenza;
	@Column (name = "cvv", unique = true, nullable = false)
	private String cvv;
	@Column (name = "credito", unique = false, nullable = false)
	private Double credito;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private User user;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Double getCredito() {
		return credito;
	}

	public void setCredito(Double credito) {
		this.credito = credito;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
