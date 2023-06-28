package com.ti.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ti.model.TOccupationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OccupationTypeDto {

	Integer occupationId;
	String occupationType;
	String state;
	String createdBy;
	Instant createDate;
	String modifiedBy;
	Instant modifiedDate;
	boolean active;

	public OccupationTypeDto(TOccupationType t) {
		occupationId = t.getId();
		occupationType = t.getOccupationType();
		state = t.getState();
		active = t.isActive();
		createdBy = t.getCreatedBy();
		createDate = t.getCreatedDate();
		modifiedBy = t.getModifiedBy();
		modifiedDate = t.getModifiedDate();

	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

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

	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
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
