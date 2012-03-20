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

public class IsUniqueExpression extends SequenceExpansionExpression {

	// Constraints
	
	/*
	 * The argument of an isUnique expression must have a multiplicity upper bound of 1.
	 */
	public void checkIsUniqueExpressionExpressionArgument() {
		
	}
	
	/*
	 * An isUnique expression has a multiplicity lower bound of 1.
	 */
	public void checkIsUniqueExpressionLowerDerivation() {
		
	}
	
	/*
	 * An isUnique expression has the type Boolean.
	 */
	public void checkIsUniqueExpressionTypeDerivation() {
		
	}
	
	/*
	 * An isUnique expression has a multiplicity upper bound of 1.
	 */
	public void checkIsUniqueExpressionUpperDerivation() {
		
	}
	
	
}
