package com.ti.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ti.dao.CustomerRepository;
import com.ti.dao.EducationalQualRepository;
import com.ti.dao.OccupationTypeRepository;
import com.ti.dao.TermInsuranceRepository;
import com.ti.dto.OccupationTypeDto;
import com.ti.dto.TermInsuranceDetailsDto;
import com.ti.mapper.TermInsuranceMapper;
import com.ti.model.TCustomer;
import com.ti.model.TEducationalQualification;
import com.ti.model.TLICustTermInsurance;
import com.ti.model.TOccupationType;

@Service
public class TermInsuranceService implements ITermInsuranceService{

	@Autowired
	TermInsuranceRepository tiRepo;
	
	@Autowired
	OccupationTypeRepository occupationRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	EducationalQualRepository eduQualRepository;
	
	/**
	 * This method is used to get term insurance details for given customer.
	 * @param customerId
	 * @return List<TLICustTermInsurance>
	 * @throws ApplicationException
	 * 
	 */
	public List<TermInsuranceDetailsDto> getTermInsuranceDetails(int customerId) {		

		List<TermInsuranceDetailsDto> list = tiRepo.findByCustomerId(customerId).stream().map(TermInsuranceDetailsDto::new).collect(Collectors.toList());
		if(list == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"NO DATA FOUND");
		}
		
		return list;
	}

	/**
	 * This method is used to add term insurance plan for given customer
	 * @param termInsuranceDetails
	 * @return {@link TLICustTermInsurance}
	 * @throws ApplicationException
	 */
	public TermInsuranceDetailsDto addTermInsuranceDetails(TLICustTermInsurance termInsuranceDetails) {
		if(termInsuranceDetails == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"INPUT IS NULL");
		}		
		if(termInsuranceDetails.getCustomer() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"NO CUSTOMER FOUND");
		}

		System.out.println("before calling customerepo ::"+termInsuranceDetails.getCustomer().getId());
		Optional<TCustomer> customer = customerRepo.findById(termInsuranceDetails.getCustomer().getId());
		System.out.println("after customerrepo ::"+customer.isEmpty());
		Optional<TEducationalQualification> eduQual = eduQualRepository.findById(termInsuranceDetails.getEduQualId().getId());
		Optional<TOccupationType> occupation = occupationRepo.findById(termInsuranceDetails.getOccupationId().getId());
				
		if(customer.isEmpty()) System.out.println("customer empty");
		if(eduQual.isEmpty()) System.out.println("Edu empty");
		if(occupation.isEmpty()) System.out.println("occu empty");
		if(customer.isEmpty() || eduQual.isEmpty() || occupation.isEmpty()) {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"BAD_REQUEST");
		}
		
		termInsuranceDetails.setCustomer(customer.get());	
		termInsuranceDetails.setEduQualId(eduQual.get());
		termInsuranceDetails.setOccupationId(occupation.get());
		termInsuranceDetails.setCreatedBy(termInsuranceDetails.getCustomer().getFirstName());
		termInsuranceDetails.setModifiedBy(termInsuranceDetails.getCustomer().getFirstName());
				
		System.out.println("termInsuranceDetails age ::"+termInsuranceDetails.getAge());
		TLICustTermInsurance entity = tiRepo.save(termInsuranceDetails);
		return TermInsuranceMapper.mapEntityToDto(entity);
	}

	/**
	 * This method is used to get all occupations.
	 * @return List<OccupationTypeDto>
	 * @throws ApplicationException
	 */
	public List<OccupationTypeDto> getAllOccupations() {
		List<OccupationTypeDto> list = occupationRepo.findAll().stream().map(OccupationTypeDto::new).collect(Collectors.toList());
		if(list == null || list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"NO OCCUPATIONS FOUND");
		}
		return list;
	}

	/**
	 * This method is used to update selected cover value of  
	 * term insurance details.
	 * @param termplanid 
	 * @param tliInsurance
	 * @throws ApplicationException 
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateTermInsuranceDetails(int termplanid, TLICustTermInsurance tliInsurance) {
		
		TLICustTermInsurance obj = tiRepo.getReferenceById(termplanid);
		
		if(obj == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"INVALID_TERM_PLAN_ID");			
		}
		
		TCustomer customer = obj.getCustomer();
		if(customer == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"NO CUSTOMER FOUND");			
		}
		
		tliInsurance.setModifiedBy(obj.getCustomer().getFirstName());
		if(tliInsurance.getSelectedCover() != null) {
			obj.setSelectedCover(tliInsurance.getSelectedCover());
		}
	}
		
}
