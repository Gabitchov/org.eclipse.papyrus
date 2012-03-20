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

public class IsolationExpression extends UnaryExpression {

	// Constraints
	
	/*
	 * An isolation expression has the multiplicity lower bound of its operand expression.
	 */
	public void checkIsolationExpressionLowerDerivation() {
		
	}
	
	/*
	 * An isolation expression has the type of its operand expression.
	 */
	public void checkIsolationExpressionTypeDerivation() {
		
	}
	
	/*
	 * An isolation expression has the multiplicity upper bound of its operand expression.
	 */
	public void checkIsolationExpressionUpperDerivation() {
		
	}
	
}
