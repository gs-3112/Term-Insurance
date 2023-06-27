package com.ti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ti.model.TLICustTermInsurance;


@Repository
public interface TermInsuranceRepository extends JpaRepository<TLICustTermInsurance, Integer>, JpaSpecificationExecutor<TLICustTermInsurance>{
	
	List<TLICustTermInsurance> findByCustomerId(Integer id);
}
