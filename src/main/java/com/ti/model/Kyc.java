package com.ti.model;

import java.time.Instant;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_KYC")
public class Kyc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_kyc_seq_gen")
	@SequenceGenerator(name = "t_kyc_seq_gen", sequenceName = "t_kyc_seq")
	Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	TCustomer customer;
	
	@Column(name="permanentAddress")
	String permanentAddress;

	@Column(name="digilockerStatus")
	Integer digilockerStatus;
	
	@Column(name = "digilockerCreatedDate")
	@CurrentTimestamp
	private Instant digilockerCreatedDate;
	
	@Column(name = "videoKYC")
	private String videoKYC;
	
	@Column(name = "lastFetchedDate")
	@CurrentTimestamp
	private Instant lastFetchedDate;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Integer getDigilockerStatus() {
		return digilockerStatus;
	}

	public void setDigilockerStatus(Integer digilockerStatus) {
		this.digilockerStatus = digilockerStatus;
	}

	public Instant getDigilockerCreatedDate() {
		return digilockerCreatedDate;
	}

	public void setDigilockerCreatedDate(Instant digilockerCreatedDate) {
		this.digilockerCreatedDate = digilockerCreatedDate;
	}

	public String getVideoKYC() {
		return videoKYC;
	}

	public void setVideoKYC(String videoKYC) {
		this.videoKYC = videoKYC;
	}

	public Instant getLastFetchedDate() {
		return lastFetchedDate;
	}

	public void setLastFetchedDate(Instant lastFetchedDate) {
		this.lastFetchedDate = lastFetchedDate;
	}

	public Kyc(Integer id, TCustomer customer, String permanentAddress, Integer digilockerStatus,
			Instant digilockerCreatedDate, String videoKYC, Instant lastFetchedDate) {
		super();
		this.id = id;
		this.customer = customer;
		this.permanentAddress = permanentAddress;
		this.digilockerStatus = digilockerStatus;
		this.digilockerCreatedDate = digilockerCreatedDate;
		this.videoKYC = videoKYC;
		this.lastFetchedDate = lastFetchedDate;
	}
	
}