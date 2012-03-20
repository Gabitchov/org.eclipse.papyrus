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

public class ConditionalLogicalExpression extends BinaryExpression {

	// Constraints
	
	/*
	 * A conditional logical expression has a multiplicity lower bound of 0 if the lower bound if either operand
	 * 	expression is 0 and 1 otherwise.
	 */
	public void checkConditionalLogicalExpressionLower() {
		
	}
	
	/*
	 * The operands of a conditional logical expression must have type Boolean.
	 */
	public void checkConditionalLogicalExpressionOperands() {
		
	}
	
	/*
	 * A conditional logical expression has type Boolean.
	 */
	public void checkConditionalLogicalExpressionTypeDerivation() {
		
	}
	
	/*
	 * A conditional logical expression has a multiplicity upper bound of 1.
	 */
	public void checkConditionalLogicalExpressionUpper() {
		
	}
	
	// Helper Operations
	
	/*
	 * If a name has the same assigned source after the second operand expression as before it, then that is its
	 * 	assigned source after the conditional logical expression. If a name is unassigned before the second
	 * 	operand expression, then it is considered unassigned after the conditional logical expression, even if it
	 * 	has an assigned source after the second operand expression. Otherwise its assigned source after the
	 * 	conditional logical expression is the conditional logical expression itself.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
	/*
	 * The assignments before the first operand expression of a conditional logical expression are the same as
	 * 	those before the conditional logical expression. The assignments before the second operand expression
	 * 	are the same as those after the first operand expression.(non-Javadoc)
	 */
	public boolean validateAssignments() {
		return false ;
	}
	
}
