package com.ti.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.ti.service.TermInsuranceService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class TermInsuranceServiceTest {

	@Mock
	private TermInsuranceRepository repo;
	@Mock
	private CustomerRepository custRepo;
	@Mock
	private EducationalQualRepository eduRepo;
	@Mock
	private OccupationTypeRepository occupationRepo;
	
	@Autowired
	private ObjectMapper objMapper;
	@Mock
	private TermInsuranceMapper mapper;
	@InjectMocks
	TermInsuranceService service;
	
	
	@Test
	public void testSaveTermInsuranceDetails() throws Exception {
		
		TCustomer customer = TCustomer.builder()
				.id(1)
				.firstName("Pratiksha")
				.lastName("Patil")
				.build();
		TEducationalQualification edu = TEducationalQualification.builder()
				.id(1)
				.educationalQuali("Master's")
				.build();
		TOccupationType occupation = TOccupationType.builder()
				.id(2)
				.occupationType("Salaried")
				.build();
		
    	TLICustTermInsurance entityRequest = TLICustTermInsurance.builder()
    			.occupationId(TOccupationType.builder().occupationType("Salaried").build())
    			.eduQualId(TEducationalQualification.builder().educationalQuali("B.Tech").build())
    			.annualIncome((double) 500000)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.eduQualId(edu)
    			.customer(customer)
    			.occupationId(occupation)
    			.build();
    	
    	TermInsuranceDetailsDto dtoResponse = TermInsuranceDetailsDto.builder()
    			.custTermInsID(1)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.build();
    	
    	TLICustTermInsurance entity = TLICustTermInsurance.builder()
    			.occupationId(TOccupationType.builder().occupationType("Salaried").build())
    			.eduQualId(TEducationalQualification.builder().educationalQuali("B.Tech").build())
    			.annualIncome((double) 500000)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.eduQualId(edu)
    			.customer(customer)
    			.occupationId(occupation)
    			.build();


    	when(custRepo.findById(any())).thenReturn(Optional.of(customer));
    	when(eduRepo.findById(any())).thenReturn(Optional.of(edu));
    	when(occupationRepo.findById(any())).thenReturn(Optional.of(occupation));
    	when(repo.save(any())).thenReturn(entity);
    	

    	TermInsuranceDetailsDto response = service.addTermInsuranceDetails(entityRequest);
    	Assertions.assertEquals(response.getLiabilities(), dtoResponse.getLiabilities());
    	Assertions.assertEquals(response.getLiabilityAmount(), dtoResponse.getLiabilityAmount());
	}
	
	@Test
	public void testGetAllOccupationsTest() throws Exception {
		
    	TOccupationType occupation1 = TOccupationType.builder()
    			.id(1)
    			.occupationType("Salaried")
    			.build();
    	
    	TOccupationType occupation2 = TOccupationType.builder()
    			.id(2)
    			.occupationType("Business Owner")
    			.build();

    	when(occupationRepo.findAll()).thenReturn(List.of(occupation1,occupation2));
    	
    	List<OccupationTypeDto> response = service.getAllOccupations();
    	
    	
    	Assertions.assertEquals(response.get(0).getOccupationId(), occupation1.getId());
    	Assertions.assertEquals(response.get(1).getOccupationId(), occupation2.getId());

    	Assertions.assertEquals(response.get(0).getOccupationType(), occupation1.getOccupationType());
    	Assertions.assertEquals(response.get(1).getOccupationType(), occupation2.getOccupationType());

		
		
	}
}
