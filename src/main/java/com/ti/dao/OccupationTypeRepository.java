package com.ti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ti.model.TOccupationType;

public interface OccupationTypeRepository extends JpaRepository<TOccupationType, Integer>, JpaSpecificationExecutor<TOccupationType> {

}
