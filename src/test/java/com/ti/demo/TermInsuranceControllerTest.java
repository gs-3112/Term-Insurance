package com.ti.demo;

import java.util.List;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ti.controller.LITermInsuranceController;
import com.ti.dto.OccupationTypeDto;
import com.ti.dto.TermInsuranceDetailsDto;
import com.ti.model.TEducationalQualification;
import com.ti.model.TLICustTermInsurance;
import com.ti.model.TOccupationType;
import com.ti.service.TermInsuranceService;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.aMapWithSize;


@WebMvcTest(LITermInsuranceController.class)
@AutoConfigureMockMvc
public class TermInsuranceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private LITermInsuranceController controller;
    
    @MockBean
    private TermInsuranceService service;
    
    @Autowired
    private ObjectMapper objMapper;
    
	/*
	 * @Test public void contextLoads() throws Exception {
	 * AssertionsForClassTypes.assertThat(controller).isNotNull(); }
	 */
    
    
    @Test
    public void getAllOccupationsTest() throws Exception {
    	System.out.println("in getAllOccupationsTest");
    	OccupationTypeDto occupation1 = OccupationTypeDto.builder()
    			.occupationId(1)
    			.occupationType("Salaried")
    			.build();
    	
    	OccupationTypeDto occupation2 = OccupationTypeDto.builder()
    			.occupationId(1)
    			.occupationType("Business Owner")
    			.build();
    	
    	
    	given(controller.getAllOccupations()).willReturn(List.of(occupation1,occupation2));
    	mockMvc.perform(get("/api/oneappabc/adityabirla/api/v1/lifeinsurance/termplan").contentType(APPLICATION_JSON))
    	.andExpect(status().isOk())
    	.andExpect(jsonPath("$", hasSize(2)))
    	.andExpect(jsonPath("$[0].occupationType",is(occupation1.getOccupationType())));
    }
    
    
    
    @Test
    public void addTermInsuranceDetailsTest() throws Exception {
    	TLICustTermInsurance dtoRequest = TLICustTermInsurance.builder()
    			.occupationId(TOccupationType.builder().occupationType("Salaried").build())
    			.eduQualId(TEducationalQualification.builder().educationalQuali("B.Tech").build())
    			.annualIncome((double) 500000)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.build();
    	
    	TermInsuranceDetailsDto dtoResponse = TermInsuranceDetailsDto.builder()
    			.custTermInsID(1)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.build();
    	
    	given(service.addTermInsuranceDetails(dtoRequest)).willReturn(dtoResponse);
    	
    	mockMvc.perform(post("/api/oneappabc/adityabirla/api/v1/lifeinsurance/termplan")
    			.contentType(APPLICATION_JSON)
    			.content(objMapper.writeValueAsString(dtoRequest)))
    			.andExpect(status().isCreated())
    			.andExpect(jsonPath("$", aMapWithSize(2)))
				.andDo(print());

    }
    

    @Test
    public void addTermInsuranceDetailsNotFoundTest() throws Exception {
    	TLICustTermInsurance dtoRequest = TLICustTermInsurance.builder()
    			.occupationId(TOccupationType.builder().occupationType("Salaried").build())
    			.eduQualId(TEducationalQualification.builder().educationalQuali("B.Tech").build())
    			.annualIncome((double) 500000)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.build();
    	
    	TermInsuranceDetailsDto dtoResponse = TermInsuranceDetailsDto.builder()
    			.custTermInsID(1)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.build();
    	
    	given(service.addTermInsuranceDetails(dtoRequest)).willReturn(dtoResponse);
    	
    	mockMvc.perform(post("/api/oneappabc/adityabirla/api/v1/lifeinsurance/badrequest")
    			.contentType(APPLICATION_JSON)
    			.content(objMapper.writeValueAsString(dtoRequest)))
    			.andExpect(status().isNotFound());

    }

    
    @Test
    public void addTermInsuranceDetailsBadRequestTest() throws Exception {
    	
    	TermInsuranceDetailsDto dtoResponse = TermInsuranceDetailsDto.builder()
    			.custTermInsID(1)
    			.liabilities((short) 1)
    			.liabilityAmount((double) 150000)
    			.existingCover((short) 0)
    			.build();

    	
    	given(service.addTermInsuranceDetails(null)).willReturn(dtoResponse);
    	mockMvc.perform(post("/api/oneappabc/adityabirla/api/v1/lifeinsurance/termplan")
    			.contentType(APPLICATION_JSON)
    			.content(objMapper.writeValueAsString(null)))
    			.andExpect(status().isBadRequest());
    }
    
    
}
