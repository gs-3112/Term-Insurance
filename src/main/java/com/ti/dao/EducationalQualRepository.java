package com.ti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ti.model.TEducationalQualification;

public interface EducationalQualRepository extends JpaRepository<TEducationalQualification, Integer>, JpaSpecificationExecutor<TEducationalQualification> {

}
