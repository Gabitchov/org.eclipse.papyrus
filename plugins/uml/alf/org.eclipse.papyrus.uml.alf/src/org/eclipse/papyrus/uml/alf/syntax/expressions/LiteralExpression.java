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

public abstract class LiteralExpression extends Expression {

	// Constraints
	
	/*
	 * The multiplicity lower bound of a literal expression is always 1.
	 */
	public void checkLiteralExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a literal expression is given by the type of the literal, as defined for each subclass below.
	 */
	public void checkLiteralExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a literal expression is always 1.
	 */
	public void checkLiteralExpressionUpperDerivation() {
		
	}
	
}
