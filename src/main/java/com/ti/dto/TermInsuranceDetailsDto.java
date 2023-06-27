package com.ti.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ti.model.TCustomer;
import com.ti.model.TEducationalQualification;
import com.ti.model.TLICustTermInsurance;
import com.ti.model.TOccupationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TermInsuranceDetailsDto {

	Integer custTermInsID;
	TCustomer customer;
	String insuredFor;
	Integer count;
	Integer age;
	Double annualIncome;
	EducationalQualificationDto eduQualId;
	OccupationTypeDto occupationId;
	Integer locationPin;
	short liabilities;
	Double liabilityAmount;
	short existingCover;
	Double existingCoverAmt;
	String policyName;
	Double maxEligCover;
	Double selectedCover;
	Double yearlyPremium;
	Instant createdDate;
	String createdBy;
	String modifiedBy;
	Instant modifiedDate;
	boolean active;
	
	
	public TermInsuranceDetailsDto(TLICustTermInsurance ti) {
		this.custTermInsID = ti.getCustTermInsID();
		this.customer = ti.getCustomer();
		this.insuredFor = ti.getInsuredFor();
		this.existingCover = ti.getExistingCover();
		this.existingCoverAmt = ti.getExistingCoverAmt();
		this.liabilities = ti.getLiabilities();
		this.liabilityAmount = ti.getLiabilityAmount();
		this.maxEligCover = ti.getMaxEligCover();
		this.policyName = ti.getPolicyName();
		this.annualIncome = ti.getAnnualIncome();
		
		TOccupationType ot = ti.getOccupationId();
		OccupationTypeDto otd = new OccupationTypeDto();
		otd.setOccupationId(ot.getOccupationId());
		otd.setOccupationType(ot.getOccupationType());
		otd.setState(ot.getState());
		otd.setActive(ot.isActive());
		this.occupationId = otd;
		
		TEducationalQualification eq = ti.getEduQualId();
		EducationalQualificationDto eqd = new EducationalQualificationDto();
		eqd.setEducationalQuali(eq.getEducationalQuali());
		eqd.setEducationalQualiId(eq.getEduQualId());
		eqd.setActive(eq.isActive());
		this.eduQualId = eqd;
		
		this.locationPin =ti.getLocationPin();		
		this.createdBy = ti.getCreatedBy();
		this.createdDate = ti.getCreatedDate();
		this.modifiedBy = ti.getModifiedBy();
		this.modifiedDate = ti.getModifiedDate();
		
	}


	public Double getAnnualIncome() {
		return annualIncome;
	}


	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}


	public Integer getCustTermInsID() {
		return custTermInsID;
	}


	public void setCustTermInsID(Integer custTermInsID) {
		this.custTermInsID = custTermInsID;
	}


	public TCustomer getCustomer() {
		return customer;
	}


	public void setCustomer(TCustomer customer) {
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


	public EducationalQualificationDto getEduQualId() {
		return eduQualId;
	}


	public void setEduQualId(EducationalQualificationDto eduQualId) {
		this.eduQualId = eduQualId;
	}


	public OccupationTypeDto getOccupationId() {
		return occupationId;
	}


	public void setOccupationId(OccupationTypeDto occupationId) {
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


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	
	

}
