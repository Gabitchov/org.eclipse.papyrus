/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.vsl.validation;

import java.util.List;

public class VSLErrorMessage {
	
	public static String getUndefinedBinaryOperatorSignatureMessage(
			String operatorSymbol, String firstOperandTypeName, String secondOperandTypeName) {
		return "Operator " 
				+ operatorSymbol 
				+ " is undefined for signature (" 
				+ firstOperandTypeName
				+ ", "
				+ secondOperandTypeName
				+ ")" ;
	}

	public static String getUndefinedUnaryOperatorSignatureMessage(String operatorSymbol,
			String operandTypeName) {
		return "Unary operator " 
			+ operatorSymbol
			+ " does not apply to type "
			+ operandTypeName ;
	}

	public static String getUntypedPropertyMessage(String propertyName) {
		return "Property " + propertyName + " is not typed" ;
	}

	public static String getMissingArgumentForChosenAlternativeMessage(String chosenAlternativeName,
			String expectedTypeName) {
		return "Argument is missing for the chosen alternative "
				+ chosenAlternativeName
				+ ". Expecting a single argument of type "
				+ expectedTypeName ;
	}
	
	public static String getTooManyArgumentsForChosenAlternativeMessage(String chosenAlternativeName,
			String expectedTypeName) {
		return "Too many arguments for the chosen alternative "
				+ chosenAlternativeName
				+ ". Expecting a single argument of type "
				+ expectedTypeName ;
	}
	
	public static String getInvalidArgumentForChosenAlternativeMessage(String chosenAlternativeName,
			String expectedTypeName, String foundTypeName) {
		return "Invalid argument for the chosen alternative "
				+ chosenAlternativeName
				+ ". Found an argument of type " 
				+ foundTypeName
				+ ". Expecting a single argument of type "
				+ expectedTypeName ;
	}

	public static String getBehaviorWithoutReturnParameterMessage(String behaviorName) {
		return "Behavior "
				+ behaviorName
				+ " has no return parameter";
	}
	
	public static String getOperationWithoutReturnParameterMessage(String operationName) {
		return "Operation "
				+ operationName
				+ " has no return parameter";
	}

	public static String getMissingArgumentsForBehaviorCall(String behaviorName, List<String> expectedTypeNames) {
		String errorMessage = "Arguments are missing for the call to behavior " ;
		errorMessage += behaviorName +"(" ;
		for (int i = 0 ; i < expectedTypeNames.size() ; i++) {
			if (i>=1)
				errorMessage+= ", " ;
			errorMessage+=expectedTypeNames.get(i) ;
		}
		errorMessage+=")" ;
		return errorMessage;
	}

	public static String getInvalidNumberOfArgumentsForBehaviorCall(String behaviorName, List<String> expectedTypeNames) {
		String errorMessage = "Invalid number of arguments for the call to behavior " ;
		errorMessage += behaviorName +"(" ;
		for (int i = 0 ; i < expectedTypeNames.size() ; i++) {
			if (i>=1)
				errorMessage+= ", " ;
			errorMessage+=expectedTypeNames.get(i) ;
		}
		errorMessage+=")" ;
		return errorMessage;
	}
	
	public static String getInvalidNumberOfArgumentsForOperationCall(String operationName, List<String> expectedTypeNames) {
		String errorMessage = "Invalid number of arguments for the call to operation " ;
		errorMessage += operationName +"(" ;
		for (int i = 0 ; i < expectedTypeNames.size() ; i++) {
			if (i>=1)
				errorMessage+= ", " ;
			errorMessage+=expectedTypeNames.get(i) ;
		}
		errorMessage+=")" ;
		return errorMessage;
	}

	public static String getInvalidArgumentsForBehaviorCall(String behaviorName,
			List<String> expectedTypeNames, List<String> foundTypeNames) {
		String errorMessage = "The behavior " ;
		errorMessage += behaviorName +"(" ;
		for (int i = 0 ; i < expectedTypeNames.size() ; i++) {
			if (i>=1)
				errorMessage+= ", " ;
			errorMessage+=expectedTypeNames.get(i) ;
		}
		errorMessage+=") is not applicable for the arguments (" ;
		for (int i = 0 ; i < foundTypeNames.size() ; i++) {
			if (i>=1)
				errorMessage+= ", " ;
			errorMessage+=foundTypeNames.get(i) ;
		}
		errorMessage += ")" ;
		return errorMessage;
	}
	
	public static String getInvalidArgumentsForOperationCall(String operationName,
			List<String> expectedTypeNames, List<String> foundTypeNames) {
		String errorMessage = "The operation " ;
		errorMessage += operationName +"(" ;
		for (int i = 0 ; i < expectedTypeNames.size() ; i++) {
			if (i>=1)
				errorMessage+= ", " ;
			errorMessage+=expectedTypeNames.get(i) ;
		}
		errorMessage+=") is not applicable for the arguments (" ;
		for (int i = 0 ; i < foundTypeNames.size() ; i++) {
			if (i>=1)
				errorMessage+= ", " ;
			errorMessage+=foundTypeNames.get(i) ;
		}
		errorMessage += ")" ;
		return errorMessage;
	}

	public static String getInvalidNumberOfExpressionsInConditionalExpression() {
		return "Invalid conditional expression. The correct syntax is: <CONDITION> ? <THEN EXPRESSION> : <ELSE EXPRESSION>";
	}

	public static String getInvalidExpressionType(String expectedTypeName, String foundTypeName) {
		return "Expecting an expression of type " + expectedTypeName + ". Found an expression of type " + foundTypeName ;
	}
}
