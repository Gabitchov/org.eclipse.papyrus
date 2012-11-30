package org.eclipse.papyrus.uml.service.types.utils;

import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Loop operand could have iteration bounds which may include a lower and an upper number of iterations of the loop. Textual syntax of the loop is:
 * loop-operand ::= loop [ '(' min-int [ ',' max-int ] ')' ]
 * min-int ::= non-negative-integer
 * max-int ::= positive-integer | '*'
 * 
 * 1. If loop has no bounds specified, it means potentially infinite loop with zero as lower bound and infinite upper bound..
 * 2. If only min-int is specified, it means that upper bound is equal to the lower bound, and loop will be executed exactly the specified
 * number of times.
 * 3. If max-int is specified, it should be greater than or equal to min-int. Loop will iterate minimum the min-int number of times and at
 * most the max-int number of times.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class InteractionConstraintUtil {

	public static Integer getNonNegativeInteger(Object value) {
		if(value == null) {
			return null;
		}
		if("*".equals(value) || "*".equals(value.toString())) {
			return Integer.MAX_VALUE;
		} else if(value instanceof Integer) {
			return (Integer)value;
		} else if(value instanceof ValueSpecification) {
			ValueSpecification valueSpec = (ValueSpecification)value;
			try {
				int intValue = valueSpec.integerValue();
				if(intValue >= 0) {
					return Integer.valueOf(intValue);
				}
			} catch (Exception e) {
				String stringValue = valueSpec.stringValue();
				if("*".equals(stringValue)) {
					return Integer.MAX_VALUE;
				}
			}
		} else {
			try {
				int intValue = Integer.parseInt(value.toString());
				if(intValue >= 0) {
					return Integer.valueOf(intValue);
				}
			} catch (NumberFormatException e) {
			}
		}
		return null;
	}

	public static Integer getMinintValue(InteractionConstraint guard) {
		if(guard == null) {
			return null;
		}
		ValueSpecification minint = guard.getMinint();
		if(minint == null) {
			return null;
		}
		try {
			int min = minint.integerValue();
			if(min >= 0) {
				return Integer.valueOf(min);
			}
		} catch (Exception e) {
			//must be a number.
		}
		return null;
	}

	public static Integer getMaxintValue(InteractionConstraint guard) {
		if(guard == null) {
			return null;
		}
		ValueSpecification maxint = guard.getMaxint();
		if(maxint == null) {
			return null;
		}
		try {
			int max = maxint.integerValue();
			if(max < 1) {
				return null;
			} else {
				return Integer.valueOf(max);
			}
		} catch (Exception e) {
			//must be a number or *.
			if("*".equals(maxint.stringValue())) {
				return Integer.MAX_VALUE;
			}
		}
		return null;
	}

}
