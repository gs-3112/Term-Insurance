package com.ti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ti.model.TCustomer;


public interface CustomerRepository extends JpaRepository<TCustomer, Long>, JpaSpecificationExecutor<TCustomer> {

}
