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

public class SequenceConstructionExpression extends Expression {

	// Synthesized Properties
	public SequenceElements elements ;
	public boolean hasMultiplicity = false ;
	public QualifiedName typeName ;
	
	//Constraints
	
	/*
	 * If a sequence construction expression has multiplicity, then its multiplicity lower bound is given by its
	 * 	elements, if this is not empty, and zero otherwise. If a sequence construction expression does not have
	 * 	multiplicity, then its multiplicity lower bound is one.
	 */
	public void checkSequenceConstructionExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type name of a sequence construction expression must resolve to a non-template classifier. If the
	 * 	expression does not have multiplicity, then this classifier must be the instantiation of a collection class.
	 */
	public void checkSequenceConstructionExpressionType() {
		
	}
	
	/*
	 * The type of a sequence construction expression is the named type.
	 */
	public void checkSequenceConstructionExpressionTypeDerivation() {
		
	}

	/*
	 * If a sequence construction expression has multiplicity, then its multiplicity upper bound is given by its
	 * 	elements, if this is not empty, and zero otherwise. If a sequence construction expression does not have
	 * 	multiplicity, then its multiplicity upper bound is one.
	 */
	public void checkSequenceConstructionExpressionUpperDerivation() {
		
	}
	
}
