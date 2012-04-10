/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.core;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.utils.OperatorExceptionMessage;

public enum Operator {
	EQ, NE, GT, LT, GE, LE, LIKE, IS_A, IS_KIND_OF;

	/**
	 * The utility helper method, to implement the compare between two objects
	 * 
	 * @param operant1
	 * @param operator
	 * @param operant2
	 * @return
	 * @throws XWTException
	 */
	public static boolean compare(Object operant1, Operator operator, Object operant2) throws XWTException {
		boolean result = false;

		switch(operator) {
		case EQ:
			result = objectCompare(operant1, operant2);
			break;

		case NE:
			if(!objectCompare(operant1, operant2))
				result = true;
			break;

		case GT:
			if(numberCompare(operant1, operant2) == 1)
				return true;
			break;

		case LT:
			if(numberCompare(operant1, operant2) == -1) {
				result = true;
			}
			break;

		case GE:
			if(numberCompare(operant1, operant2) == 1 || numberCompare(operant1, operant2) == 0) {
				result = true;
			}
			break;

		case LE:
			if(numberCompare(operant1, operant2) == -1 || numberCompare(operant1, operant2) == 0) {
				result = true;
			}
			break;

		case LIKE:
			return LikeCompare(operant1, operant2);

		case IS_A:
			if(operant2 instanceof Class<?>) {
				return ISACompare(operant1, (Class<?>)operant2);
			} else {
				throw new XWTException(OperatorExceptionMessage.TYPE_WRONG);
			}

		case IS_KIND_OF:
			return isKindOfCompare(operant1, operant2);
		}
		return result;
	}

	private static boolean isKindOfCompare(Object operant1, Object operant2) {
		return operant2.getClass().isInstance(operant1);
	}

	/**
	 * @param operant1
	 * @param operant2
	 * @return
	 * @throws XWTException
	 */
	private static int numberCompare(Object operant1, Object operant2) throws XWTException {
		if(operant1 == null || operant2 == null) {
			throw new XWTException(OperatorExceptionMessage.OPRERANR_NULL);
		}
		Double longoperant1 = convertToDouble(operant1);
		Double longoperant2 = convertToDouble(operant2);
		return DoubleCompare(longoperant1, longoperant2);
	}

	/**
	 * convert the type of operant to the Double
	 * 
	 * @param operant
	 * @return
	 * @throws XWTException
	 */
	private static Double convertToDouble(Object operant) throws XWTException {
		if(operant instanceof Double) {
			return (Double)operant;
		}
		if(operant instanceof Float) {
			Float floatvalue = (Float)operant;
			return Double.parseDouble(String.valueOf(floatvalue));
		}
		if(operant instanceof Integer) {
			Integer integer = (Integer)operant;
			return Double.parseDouble(String.valueOf(integer));
		}
		if(operant instanceof Character) {
			Character character = (Character)operant;
			if(Character.isDigit(character)) {
				int numericValue = Character.getNumericValue(character);
				return Double.parseDouble(String.valueOf(numericValue));
			}
		}
		if(operant instanceof Short) {
			Short shortvalue = (Short)operant;
			return Double.parseDouble(String.valueOf(shortvalue));
		}
		if(operant instanceof Byte) {
			Byte bytevalue = (Byte)operant;
			return Double.parseDouble(String.valueOf(bytevalue));
		}
		if(operant instanceof Long) {
			Long floatvalue = (Long)operant;
			return Double.parseDouble(String.valueOf(floatvalue));
		}
		if(operant instanceof BigDecimal) {
			BigDecimal bigdecimalvalue = (BigDecimal)operant;
			return Double.parseDouble(String.valueOf(bigdecimalvalue));
		} else
			throw new XWTException(OperatorExceptionMessage.TYPE_WRONG);
	}

	/**
	 * the compare of two object for NE,EQ
	 * 
	 * @param operant1
	 * @param operant2
	 * @return
	 */
	private static boolean objectCompare(Object operant1, Object operant2) {
		if(operant1 == operant2) {
			return true;
		}
		if(operant1 != null) {
			return operant1.equals(operant2);
		} else if(operant1 != null) {
			return operant2.equals(operant1);
		}
		return false;
	}

	/**
	 * the compare of two object for ISA
	 * 
	 * @param operant1
	 * @param operant2
	 * @return
	 * @throws XWTException
	 */
	private static boolean ISACompare(Object operant1, Class<?> clazz) {
		return clazz.isInstance(operant1);
	}

	/**
	 * the compare of two Double
	 * 
	 * @param operant1
	 * @param operant2
	 * @return
	 */
	private static int DoubleCompare(Double operant1, Double operant2) {
		return (operant1.compareTo(operant2) < 0 ? -1 : (operant1.compareTo(operant2) == 0 ? 0 : 1));
	}

	/**
	 * the compare of two String for Like
	 * 
	 * @param operant1
	 * @param operant2
	 * @return
	 * @throws XWTException
	 */
	private static boolean LikeCompare(Object operant1, Object operant2) throws XWTException {
		if(operant1 == null || operant2 == null) {
			throw new XWTException(OperatorExceptionMessage.OPRERANR_NULL);
		}
		if(operant1 instanceof String && operant2 instanceof String) {
			String operant1String = (String)operant1;
			String operant2String = (String)operant2;
			String queryString = parseRegularExpressionString(operant1String);
			Pattern pattern = Pattern.compile(queryString);
			Matcher matcher = pattern.matcher(operant2String);
			return matcher.find();
		}
		throw new XWTException(OperatorExceptionMessage.TYPE_WRONG);
	}

	/**
	 * build the regular expressions
	 * 
	 * @param queryString
	 * @return
	 */
	public static String parseRegularExpressionString(String queryString) {
		String result = queryString;
		result = result.replace("?", ".");
		result = result.replace("*", ".*");
		return result;
	}
}
