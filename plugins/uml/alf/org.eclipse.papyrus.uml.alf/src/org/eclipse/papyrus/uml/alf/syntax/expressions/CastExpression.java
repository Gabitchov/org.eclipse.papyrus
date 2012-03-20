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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.alf.syntax.common.AssignedSource;

public class CastExpression extends Expression {
	
	// Synthesized Properties
	public Expression operand ;
	public QualifiedName typeName ;
	
	// Constraints
	
	/*
	 * The assignments before the operand of a cast expression are the same as those before the cast
	 * 	expression.
	 */
	public void checkCastExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * A cast expression has a multiplicity lower bound of 0.
	 */
	public void checkCastExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a cast expression is the referent of the given type name (if there is one).
	 */
	public void checkCastExpressionTypeDerivation() {
		
	}
	
	/*
	 * If the cast expression has a type name, then it must resolve to a classifier.
	 */
	public void checkCastExpressionTypeResolution() {
		
	}
	
	/*
	 * A cast expression has a multiplicity upper bound that is the same as the upper bound of its operand
	 * 	expression.
	 */
	public void checkCastExpressionUpperDerivation() {
		
	}
	
	// Helper Operations
	
	/*
	 * The assignments after a cast expression are the same as those after its operand expression.
	 */
	public List<AssignedSource> updateAssignments ( ) {
		return new ArrayList<AssignedSource>() ;
	}
}
