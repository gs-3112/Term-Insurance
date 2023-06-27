package com.ti.service;

import java.util.List;

import com.ti.dto.OccupationTypeDto;
import com.ti.dto.TermInsuranceDetailsDto;
import com.ti.model.TLICustTermInsurance;

public interface ITermInsuranceService {

	List<TermInsuranceDetailsDto> getTermInsuranceDetails(int customerId);
	TermInsuranceDetailsDto addTermInsuranceDetails(TLICustTermInsurance termInsuranceDetails);
	List<OccupationTypeDto> getAllOccupations();
	void updateTermInsuranceDetails(int id, TLICustTermInsurance tliInsurance);
}
