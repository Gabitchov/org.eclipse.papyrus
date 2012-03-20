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

public class ForAllOrExistsOrOneExpression extends SequenceExpansionExpression {

	// Constraints
	
	/*
	 * The argument of a forAll, exists or one expression must have type Boolean and a multiplicity upper
	 * 	bound of 1.
	 */
	public void checkForAllOrExistOrOneExpressionArgument() {
		
	}
	
	/*
	 * A forAll, exists or one expression has a multiplicity lower bound of 1.
	 */
	public void checkForAllOrExistOrOneExpressionLowerDerivation() {
		
	}
	
	/*
	 * A forAll, exists or one expression has the type Boolean.
	 */
	public void checkForAllOrExistOrOneExpressionTypeDerivation() {
		
	}
	
	/*
	 * A forAll, exists or one expression has a multiplicity upper bound of 1.
	 */
	public void checkForAllOrExistOrOneExpressionUpperDerivation() {
		
	}
	
}
