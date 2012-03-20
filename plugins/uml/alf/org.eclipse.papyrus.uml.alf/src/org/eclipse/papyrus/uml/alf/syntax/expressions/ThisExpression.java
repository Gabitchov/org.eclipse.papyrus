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

public class ThisExpression extends Expression {

	// Constraints
	/*
	 * The multiplicity lower bound of a this expression is always 1.
	 */
	public void checkThisExpressionLowerDerivation() {
		
	}
	
	/*
	 * The static type of a this expression is the statically determined context classifier for the context in which
	 * 	the this expression occurs.
	 */
	public void checkThisExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a this expression is always 1.
	 */
	public void checkThisExpressionUpperDerivation() {
		
	}
	
}
