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

public class NumericUnaryExpression extends UnaryExpression {

	// Constraints
	
	/*
	 * A numeric unary expression has the same multiplicity lower bound as its operand expression.
	 */
	public void checkNumericUnaryExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operand expression must have type Integer and a multiplicity upper bound of 1.
	 */
	public void checkNumericUnaryExpressionOperand() {
		
	}
	
	/*
	 * A numeric unary expression must have type Integer.
	 */
	public void checkNumericUnaryExpressionTypeDerivation() {
		
	}
	
	/*
	 * A numeric unary expression has a multiplicity upper bound of 1.
	 */
	public void checkNumericUnaryExpressionUpperDerivation() {
		
	}
	
	
}
