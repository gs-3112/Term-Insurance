package com.ti.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "T_EducationalQualification")
public class TEducationalQualification {

	@Id
	@Column(name = "eduQualId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer eduQualId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private TCustomer customer;
	
	@Column(name="educationalQuali")
	private String educationalQuali;
	
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

	@Column(name="active")
	boolean active;

}
