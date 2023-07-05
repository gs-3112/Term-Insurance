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
import jakarta.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_educational_qualification_seq_gen")
	@SequenceGenerator(name = "t_educational_qualification_seq_gen", sequenceName = "t_educational_qualification_seq")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private TCustomer customer;
	
	@Column(name="educationalquali")
	private String educationalQuali;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "createddate")
	@CreatedDate
	private Instant createdDate;

	@Column(name = "modifiedby")
	private String modifiedBy;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	private Instant modifiedDate;

	@Column(name="active")
	String active;

}
