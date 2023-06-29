package com.ti.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ti.dto.CalculationResultDto;
import com.ti.model.TLICustTermInsurance;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Service
public class TermPlanCalculator {

	public CalculationResultDto insuranceCalculator(TLICustTermInsurance termInsurance) {
		double IncomeMultiplier1 = 0;
		double IncomeMultiplier2 = 0;

		long minimumcover = 0;
		long minimumROundOff = 0;
		long totaleligiblecover = 0;
		
		if (termInsurance.getAge() >= 18 && termInsurance.getAge() <= 35) {
			IncomeMultiplier1 = 25;
			IncomeMultiplier2 = 0.9;
		} else if (termInsurance.getAge() >= 36 && termInsurance.getAge() <= 40) {
			IncomeMultiplier1 = 20;
			IncomeMultiplier2 = 0.8;
		} else if (termInsurance.getAge() >= 41 && termInsurance.getAge() <= 45) {
			IncomeMultiplier1 = 15;
			IncomeMultiplier2 = 0.75;
		} else if (termInsurance.getAge() >= 46 && termInsurance.getAge() <= 50) {
			IncomeMultiplier1 = 12;
			IncomeMultiplier2 = 0.7;
		} else if (termInsurance.getAge() >= 51 && termInsurance.getAge() <= 55) {
			IncomeMultiplier1 = 10;
			IncomeMultiplier2 = 0.65;
		} else if (termInsurance.getAge() >= 56 && termInsurance.getAge() <= 65) {
			IncomeMultiplier1 = 5;
			IncomeMultiplier2 = 0.6;
		} else {
			System.out.println("Please Entered Correct Age");

		}
		totaleligiblecover = (long) Math
				.max((termInsurance.getAnnualIncome() * IncomeMultiplier1) - termInsurance.getExistingCover(), 0);
		Double totalcover = new Double(totaleligiblecover);
		if (totaleligiblecover > termInsurance.getLiabilityAmount()) {
			minimumcover = (long) min((max(termInsurance.getLiabilityAmount()
					+ (totaleligiblecover - termInsurance.getLiabilityAmount()) * IncomeMultiplier2
					- termInsurance.getExistingCover(), 0)), totaleligiblecover);
			System.out.println(minimumcover);

		}
		if (minimumcover > 5000000) {
			minimumROundOff = roundCeil(minimumcover);
		} else {
			minimumROundOff = 5000000;
		}

		CalculationResultDto result = CalculationResultDto.builder().minCover(minimumcover)
				.minCoverRoundOff(minimumROundOff).totalEligibleCover(totalcover).build();
		return result;
	}

	public static long roundCeil(long input) {
		long i = (long) Math.ceil(input);
		return ((i + 999999) / 1000000) * 1000000;
	}

}
