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

public class SelectOrRejectExpression extends SequenceExpansionExpression {

	// Constraints
	
	/*
	 * The argument of a select or reject expression must have type Boolean and a multiplicity upper bound of
	 * 	1.
	 */
	public void checkSelectOrRejectExpressionArgument() {
		
	}
	
	/*
	 * A select or reject expression has a multiplicity lower bound of 0.
	 */
	public void checkSelectOrRejectExpressionLowerDerivation() {
		
	}
	
	/*
	 * A select or reject expression has the same type as its primary expression.
	 */
	public void checkSelectOrRejectExpressionTypeDerivation() {
		
	}
	
	/*
	 * A select or reject expression has a multiplicity upper bound of *.
	 */
	public void checkSelectOrRejectExpressionUpperDerivation() {
		
	}
	
	
}
