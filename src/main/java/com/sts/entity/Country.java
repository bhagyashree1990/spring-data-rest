package com.sts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = "name",name = "country_name_unq")
})
public class Country {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String shortName;
	private Integer phoneCode;
	
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Integer getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(Integer phoneCode) {
		this.phoneCode = phoneCode;
	}
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", shortName=" + shortName + ", phoneCode=" + phoneCode + "]";
	}		
}
