package it.dstech.Supermarket.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity (name = "user")
public class User extends Base {
	
	@Column (name = "username", nullable = false, unique = true)
	private String username;
	@Column (name = "password", nullable = false, unique = true)
	private String password;
	
	@Enumerated (EnumType.STRING)
	private UserProfile userProfileType;
	
	@Column (name = "telefono", nullable = false, unique = false)
	private String telefono;
	
	@Column (name = "via", nullable = false, unique = false)
	private String via;
	
	@Column (name = "cap", nullable = false, unique = false)
	private String cap;
	
	@Column (name = "citta", nullable = false, unique = false)
	private String citta;
	
	@Column (name = "provincia", nullable = false, unique = false)
	private String provincia;
	
	@OneToMany (mappedBy = "user")
	private List <CartaCredito> listaCarteCredito;
	
	@OneToMany (mappedBy = "user")
	private List <Storico> listaStorico;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfileType() {
		return userProfileType;
	}

	public void setUserProfileType(UserProfile userProfileType) {
		this.userProfileType = userProfileType;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<CartaCredito> getListaCarteCredito() {
		return listaCarteCredito;
	}

	public void setListaCarteCredito(List<CartaCredito> listaCarteCredito) {
		this.listaCarteCredito = listaCarteCredito;
	}

	public List<Storico> getListaStorico() {
		return listaStorico;
	}

	public void setListaStorico(List<Storico> listaStorico) {
		this.listaStorico = listaStorico;
	}

	
}
