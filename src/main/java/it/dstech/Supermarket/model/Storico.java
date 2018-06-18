package it.dstech.Supermarket.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name = "storico")
public class Storico extends Base {

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;

	@Column (name = "totale", unique = false, nullable = false)
	private Double totale;
	@Column (name = "data", unique = false, nullable = false)
	private LocalDate data;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getTotale() {
		return totale;
	}
	public void setTotale(Double totale) {
		this.totale = totale;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
}
