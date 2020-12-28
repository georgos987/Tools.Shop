package net.tools.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customer_address")
@Data
public class CustomerAddress {
	
	public CustomerAddress() {
	}

	public CustomerAddress(String country, String city, String street, String zipCode ) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "zip_code")
	private String zipCode;

	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
			,CascadeType.PERSIST,CascadeType.REFRESH}, targetEntity = Customer.class, mappedBy = "address")
	private Customer customer;

}
