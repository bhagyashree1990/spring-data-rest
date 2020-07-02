package com.sts.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "name",name = "state_name_unq")
	})
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="{name.empty}")
	private String name;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "country_id_fk"))
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", country=" + country.getName() + "]";
	}		
}
