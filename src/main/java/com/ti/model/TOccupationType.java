package com.ti.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@Table(name = "T_OccupationType")
public class TOccupationType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_occupation_type_seq_gen")
	@SequenceGenerator(name = "t_occupation_type_seq_gen", sequenceName = "t_occupation_type_seq")
	private Integer id;

	@Column(name = "occupationType")
	private String occupationType;

	@Column(name = "state")
	private String state;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "createdDate")
	@CreatedDate
	private Instant createdDate;

	@Column(name = "modifiedBy")
	private String modifiedBy;

	@Column(name = "modifiedDate")
	@LastModifiedDate
	private Instant modifiedDate;

	@Column(name = "active")
	boolean active;

	
	
	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Instant getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Instant modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
