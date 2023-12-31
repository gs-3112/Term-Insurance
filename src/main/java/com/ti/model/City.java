package com.ti.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_City")
public class City {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "city")
	private String city;

	@Column(name = "createdby")
	private String createdby;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "modifiedby")
	private String modifiedBy;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "modififeddate")
	private Date modififedDate;

	@Column(name = "active")
	private String active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	@JsonBackReference
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModififedDate() {
		return modififedDate;
	}

	public void setModififedDate(Date modififedDate) {
		this.modififedDate = modififedDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(long id, String city, String createdby, Date createdDate, String modifiedBy, Date modififedDate,
			String active, Address address) {
		super();
		this.id = id;
		this.city = city;
		this.createdby = createdby;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modififedDate = modififedDate;
		this.active = active;
		this.address = address;
	}

}