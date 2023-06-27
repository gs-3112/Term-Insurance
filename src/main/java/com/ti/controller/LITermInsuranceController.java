package com.ti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.dto.OccupationTypeDto;
import com.ti.dto.TermInsuranceDetailsDto;
import com.ti.model.TLICustTermInsurance;
import com.ti.service.ITermInsuranceService;

@RestController
@RequestMapping("/termplan")
public class LITermInsuranceController {

	@Autowired
	ITermInsuranceService tiService;
		
	@GetMapping("{customerId}")
	public List<TermInsuranceDetailsDto> getTermInsuranceDetails(@PathVariable int customerId) {
		return tiService.getTermInsuranceDetails(customerId);
	}
	
	@PostMapping
	public TermInsuranceDetailsDto addTermInsuranceDetails(@RequestBody TLICustTermInsurance termInsuranceDetails) {
		return tiService.addTermInsuranceDetails(termInsuranceDetails);
	}
	
	@PatchMapping("/{id}")
	public void updateTermInsuranceDetails(@PathVariable int id,@RequestBody TLICustTermInsurance tliInsurance) {
		tiService.updateTermInsuranceDetails(id,tliInsurance);
	}
	
	@GetMapping("/occupations")
	public List<OccupationTypeDto> getAllOccupations() {
		return tiService.getAllOccupations();
	}

}

