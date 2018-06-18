package it.dstech.Supermarket.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Base {

	@Id
	@GeneratedValue
	@SequenceGenerator (name = "sequence_name", allocationSize = 1, initialValue = 1)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
