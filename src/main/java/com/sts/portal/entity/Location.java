package com.sts.portal.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "pincode",name = "pincode_unq")
	})
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String pincode;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "loc_city_id_fk"))
	private City city;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "loc_state_id_fk"))
	private State state;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "loc_country_id_fk"))
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", pincode=" + pincode + ", city=" + city.getName() + ", state=" + state.getName() + ", country="
				+ country.getName() + "]";
	}
	
	
}
