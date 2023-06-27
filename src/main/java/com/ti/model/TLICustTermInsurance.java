package com.ti.model;

import java.time.Instant;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor
@Table(name="T_Cust_Term_Insurance")
public class TLICustTermInsurance {

	@Id
	@Column(name="custTermInsID", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer custTermInsID;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private TCustomer customer;

	@Column(name="insuredFor")
	private String insuredFor;
	
	@Column(name="count")
	private Integer count;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="annualIncome")
	private Double annualIncome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="eduQualId")
	private TEducationalQualification eduQualId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="occupationId")
	private TOccupationType occupationId;
	
	@Column(name="locationPin")
	private Integer locationPin;
	
	@Column(name="liabilities")
	private short liabilities;
	
	@Column(name="liabilityAmount")
	private Double liabilityAmount;
	
	@Column(name="existingCover")
	private short existingCover;

	@Column(name="existingCoverAmt")
	private Double existingCoverAmt;
	
	@Column(name="policyName")
	private String policyName;
	
	@Column(name="maxEligCover")
	private Double maxEligCover;
	
	@Column(name="selectedCover")
	private Double selectedCover;
	
	@Column(name="yearlyPremium")
	private Double yearlyPremium;
	
	@Column(name = "createdDate")
	@CurrentTimestamp
	private Instant createdDate;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "modifiedBy")
	private String modifiedBy;
	
	@Column(name = "modifiedDate")
	@UpdateTimestamp
	private Instant modifiedDate;

	@Column(name="active", nullable = false)
	boolean active;

	public Integer getCustTermInsID() {
		return custTermInsID;
	}

	public void setCustTermInsID(Integer custTermInsID) {
		this.custTermInsID = custTermInsID;
	}

	public TCustomer getCustomer() {
		return customer;
	}

	public void setId(TCustomer customer) {
		this.customer = customer;
	}

	public String getInsuredFor() {
		return insuredFor;
	}

	public void setInsuredFor(String insuredFor) {
		this.insuredFor = insuredFor;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public TEducationalQualification getEduQualId() {
		return eduQualId;
	}

	public void setEduQualId(TEducationalQualification eduQualId) {
		this.eduQualId = eduQualId;
	}

	public TOccupationType getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(TOccupationType occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getLocationPin() {
		return locationPin;
	}

	public void setLocationPin(Integer locationPin) {
		this.locationPin = locationPin;
	}

	public short getLiabilities() {
		return liabilities;
	}

	public void setLiabilities(short liabilities) {
		this.liabilities = liabilities;
	}

	public Double getLiabilityAmount() {
		return liabilityAmount;
	}

	public void setLiabilityAmount(Double liabilityAmount) {
		this.liabilityAmount = liabilityAmount;
	}

	public short getExistingCover() {
		return existingCover;
	}

	public void setExistingCover(short existingCover) {
		this.existingCover = existingCover;
	}

	public Double getExistingCoverAmt() {
		return existingCoverAmt;
	}

	public void setExistingCoverAmt(Double existingCoverAmt) {
		this.existingCoverAmt = existingCoverAmt;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Double getMaxEligCover() {
		return maxEligCover;
	}

	public void setMaxEligCover(Double maxEligCover) {
		this.maxEligCover = maxEligCover;
	}

	public Double getSelectedCover() {
		return selectedCover;
	}

	public void setSelectedCover(Double selectedCover) {
		this.selectedCover = selectedCover;
	}

	public Double getYearlyPremium() {
		return yearlyPremium;
	}

	public void setYearlyPremium(Double yearlyPremium) {
		this.yearlyPremium = yearlyPremium;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}	
	
	
	
}
