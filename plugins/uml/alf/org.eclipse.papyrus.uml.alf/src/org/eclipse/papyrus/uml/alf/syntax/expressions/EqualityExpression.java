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

public class EqualityExpression extends BinaryExpression {

	// Derived Properties
	public boolean isNegated ;

	// Constraints
	
	/*
	 * An equality expression is negated if its operator is "!=".
	 */
	public void checkEqualityExpressionIsNegatedDerivation() {
		
	}
	
	/*
	 * An equality expression has a multiplicity lower bound of 1.
	 */
	public void checkEqualityExpressionLowerDerivation() {
		
	}
	
	/*
	 * An equality expression has type Boolean.
	 */
	public void checkEqualityExpressionTypeDerivation() {
		
	}
	
	/*
	 * An equality expression has a multiplicity upper bound of 1.
	 */
	public void checkEqualityExpressionUpperDerivation() {
		
	}
	
}
