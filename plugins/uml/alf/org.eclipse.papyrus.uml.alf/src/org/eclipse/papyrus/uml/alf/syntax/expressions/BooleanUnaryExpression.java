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

public class BooleanUnaryExpression extends UnaryExpression {

	// Constraints
	
	/*
	 * A Boolean unary expression has the same multiplicity lower bound as its operand expression.
	 */
	public void checkBooleanUnaryExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operand expression of a Boolean unary expression must have type Boolean and a multiplicity upper
	 * 	bound of 1.
	 */
	public void checkBooleanUnaryExpressionOperand() {
		
	}
	
	/*
	 * A Boolean unary expression has type Boolean.
	 */
	public void checkBooleanUnaryExpressionTypeDerivation() {
		
	}
	
	/*
	 * A Boolean unary expression has a multiplicity upper bound of 1.
	 */
	public void checkBooleanUnaryExpressionUpperDerivation() {
		
	}
	
}
