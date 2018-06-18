package it.dstech.Supermarket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "prodotto")
public class Prodotto extends Base{

	@Column(name = "nome", unique = false, nullable = false)
	private String nome;
	
	@Column(name = "marca", unique = false, nullable = false)
	private String marca;
	
	@Column(name = "data_di_scadenza", unique = false, nullable = false)
	private LocalDate dataDiScadenza;
	
	@Column(name = "categoria", unique = false, nullable = false)
	private Categoria categoria;
	
	@Column(name = "quantita_disponibile", unique = false, nullable = false)
	private int quantitaDisponibile;
	
	@Column(name = "unita", unique = false, nullable = false)
	private Unita unita;
	
	@Column(name = "prezzo_unitario", unique = false, nullable = false)
	private double prezzoUnitario;
	
	@Column(name = "prezzo_ivato", unique = false, nullable = false)
	private double prezzoIvato;
	
	@Column(name = "offerta", unique = false, nullable = false)
	private int offerta;
	
	
	//getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDate getDataDiScadenza() {
		return dataDiScadenza;
	}

	public void setDataDiScadenza(LocalDate dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public Unita getUnita() {
		return unita;
	}

	public void setUnita(Unita unita) {
		this.unita = unita;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public double getPrezzoIvato() {
		return prezzoIvato;
	}

	public void setPrezzoIvato(double prezzoIvato) {
		this.prezzoIvato = prezzoIvato;
	}

	public int getOfferta() {
		return offerta;
	}

	public void setOfferta(int offerta) {
		this.offerta = offerta;
	}
	
	
}
