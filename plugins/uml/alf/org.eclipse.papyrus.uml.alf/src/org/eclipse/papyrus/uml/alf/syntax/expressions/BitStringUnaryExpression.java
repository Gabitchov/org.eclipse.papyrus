/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.alf.syntax.expressions;

public class BitStringUnaryExpression extends UnaryExpression {
	
	// Derived Properties
	protected boolean isBitStringConversion ;
	
	// Constraints
	
	/*
	 * BitString conversion is required if the operand expression of a BitString unary expression has type
	 * 	Integer.
	 */
	public void checkBitStringUnaryExpresionIsBitStringConversionDerivation() {
		
	}
	
	/*
	 * A BitString unary expression has the same multiplicity lower bound as its operand expression.
	 */
	public void checkBitStringUnaryExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operand expression of a BitString unary expression must have type BitString or Integer and a
	 * 	multiplicity upper bound of 1.
	 */
	public void checkBitStringUnaryExpressionOperand() {
		
	}
	
	/*
	 * A BitString unary expression has type BitString.
	 */
	public void checkBitStringUnaryExpressionTypeDerivation() {
		
	}
	
	/*
	 * A BitString unary expression has a multiplicity upper bound of 1.
	 */
	public void checkBitStringUnaryExpressionUpperDerivation() {
		
	}
	
}
