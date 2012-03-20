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

public class ClassExtentExpression extends Expression {
	
	//Synthesized Properties
	public QualifiedName className ; 
	
	//Constraints
	/*
	 * The given type name must resolve to a non-template class.
	 */
	public void checkClassExtentExpressionExtentType() {
		
	}
	
	/*
	 * The multiplicity lower bound of a class extent expression is 0.
	 */
	public void checkClassExtentExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a class extent expression is the given class.
	 */
	public void checkClassExtentExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a class expression is *.
	 */
	public void checkClassExtentExpressionUpperDerivation() {
		
	}
}
