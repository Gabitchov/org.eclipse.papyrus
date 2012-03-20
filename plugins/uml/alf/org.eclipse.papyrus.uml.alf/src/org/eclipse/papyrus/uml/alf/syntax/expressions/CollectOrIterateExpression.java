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

public class CollectOrIterateExpression extends SequenceExpansionExpression {

	// Constraints
	
	/*
	 * A collect or iterate expression has a multiplicity lower bound that is the product of the bounds of its
	 * 	primary and argument expressions.
	 */
	public void checkCollectOrIterateExpressionLowerDerivation() {
		
	}
	
	/*
	 * A collect or iterate expression has the same type as its argument expression.
	 */
	public void checkCollectOrIterateExpressionTypeDerivation() {
		
	}
	
	/*
	 * A collect or iterate expression has a multiplicity upper bound that is the product of the bounds of its
	 * 	primary and argument expressions.
	 */
	public void checkCollectOrIterateExpressionUpperDerivation() {
		
	}
	
}
