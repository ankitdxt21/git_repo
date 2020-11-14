package com.prac.test;

import java.util.Arrays;

public class ValidCombination {

	public static void main(String[] args) {

		String[] updateTypes = { "BUNDLE_UPDATE", "RH850_UPDATE", "LGIT_UPDATE" };
		boolean isCombinationValid = isCombinationValid(updateTypes);
		System.out.println(isCombinationValid);
	}

	private static boolean isCombinationValid(String[] val) {
		return Arrays.stream(ValidCombinationEnum.values())
				.anyMatch(e -> Arrays.equals(val, e.getValidCombinationList()));

	}

}

enum ValidCombinationEnum {
	MULTI_BB_RH("FRAMEWORK_UPDATE", "RH850_UPDATE"), 
	MULTI_BB_RO("FRAMEWORK_UPDATE", "CUSTRO_UPDATE"), 
	MULTI_BU_RH,LGIT("BUNDLE_UPDATE", "RH850_UPDATE", "LGIT_UPDATE");

	private final String[] updateTypes;

	ValidCombinationEnum(String... updateTypes) {
		this.updateTypes = updateTypes;
	}

	public String[] getValidCombinationList() {
		return updateTypes;
	}
}
