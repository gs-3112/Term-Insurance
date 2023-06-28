package com.ti.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ti.model.TEducationalQualification;
import com.ti.model.TOccupationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationalQualificationDto {
	
	Integer educationalQualiId;
	String educationalQuali;	
	boolean isActive;
	
	public EducationalQualificationDto(TEducationalQualification t) {
		educationalQualiId = t.getId();
		educationalQuali = t.getEducationalQuali();
		isActive = t.isActive();
	}


	
	public Integer getEducationalQualiId() {
		return educationalQualiId;
	}
	public void setEducationalQualiId(Integer educationalQualiId) {
		this.educationalQualiId = educationalQualiId;
	}
	public String getEducationalQuali() {
		return educationalQuali;
	}
	public void setEducationalQuali(String educationalQuali) {
		this.educationalQuali = educationalQuali;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
