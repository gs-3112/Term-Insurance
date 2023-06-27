package com.ti.mapper;

import org.springframework.stereotype.Component;

import com.ti.dto.EducationalQualificationDto;
import com.ti.dto.OccupationTypeDto;
import com.ti.dto.TermInsuranceDetailsDto;
import com.ti.model.TCustomer;
import com.ti.model.TEducationalQualification;
import com.ti.model.TLICustTermInsurance;
import com.ti.model.TOccupationType;

@Component
public class TermInsuranceMapper {
	
	public static TLICustTermInsurance mapDtoToEntity(TermInsuranceDetailsDto dto) {
		TLICustTermInsurance custTermInsurance =TLICustTermInsurance.builder()
				.customer(TCustomer.builder().dateOfBirth(dto.getCustomer().getDateOfBirth()).build())
				.eduQualId(TEducationalQualification.builder().educationalQuali(dto.getEduQualId().getEducationalQuali()).build())
				.occupationId(TOccupationType.builder().occupationType(dto.getOccupationId().getOccupationType()).build())
				.annualIncome(dto.getAnnualIncome())
				.liabilities(dto.getLiabilities())
				.liabilityAmount(dto.getLiabilityAmount())
				.existingCover(dto.getExistingCover())
				.existingCoverAmt(dto.getExistingCoverAmt())
				.createdBy(dto.getCreatedBy())
				.createdDate(dto.getCreatedDate())
				.modifiedBy(dto.getModifiedBy())
				.modifiedDate(dto.getModifiedDate())
				.build();
		
		return custTermInsurance;
		
	}
	
	public static TermInsuranceDetailsDto mapEntityToDto(TLICustTermInsurance entity) {
		TermInsuranceDetailsDto dto = TermInsuranceDetailsDto.builder()
				.custTermInsID(entity.getCustTermInsID())
				.customer(entity.getCustomer())
				.eduQualId(EducationalQualificationDto.builder()
						.educationalQualiId(entity.getEduQualId().getEduQualId())
						.educationalQuali(entity.getEduQualId().getEducationalQuali())
						.isActive(entity.getEduQualId().isActive())
						.build())
				.occupationId(OccupationTypeDto.builder()
						.occupationId(entity.getOccupationId().getOccupationId())
						.occupationType(entity.getOccupationId().getOccupationType())
						.createdBy(entity.getOccupationId().getCreatedBy())
						.createDate(entity.getOccupationId().getCreatedDate())
						.modifiedBy(entity.getOccupationId().getModifiedBy())
						.modifiedDate(entity.getOccupationId().getModifiedDate())
						.build())
				.annualIncome(entity.getAnnualIncome())
				.liabilities(entity.getLiabilities())
				.liabilityAmount(entity.getLiabilityAmount())
				.existingCover(entity.getExistingCover())
				.existingCoverAmt(entity.getExistingCoverAmt())
				.createdBy(entity.getCreatedBy())
				.createdDate(entity.getCreatedDate())
				.modifiedBy(entity.getModifiedBy())
				.modifiedDate(entity.getModifiedDate())				
				.build();
		
		return dto;
		
		
	}
}
