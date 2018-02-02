package fr.ca.commons.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtil {
	
	public static BigDecimal round(BigDecimal value, String increment, RoundingMode roundingMode) {
		BigDecimal bdIncrement = bd(increment);
		if (bdIncrement.signum() == 0) {
			// 0 increment does not make much sense, but prevent division by 0
			return value;
		} else {
			BigDecimal divided = value.divide(bdIncrement, 0, roundingMode);
			BigDecimal result = divided.multiply(bdIncrement);
			return result;
		}
	}
	
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
}
