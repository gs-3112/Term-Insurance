package com.ti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CalculationResultDto {
	
	private double totalEligibleCover;
	private double minCoverRoundOff;
	private double minCover;
	
}
