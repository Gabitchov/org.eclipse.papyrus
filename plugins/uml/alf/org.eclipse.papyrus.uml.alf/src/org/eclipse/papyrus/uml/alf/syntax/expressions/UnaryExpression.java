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

public class UnaryExpression extends Expression {

	// Synthesized Properties
	public Expression operand ;
	public String operator ;
	
	// Constraints
	
	/*
	 * The assignments before the operand of a unary expression are the same as those before the unary
	 * 	expression.
	 */
	public void checkUnaryExpressionAssignmentsBefore() {
		
	}
	
	//Helper Operations
	/*
	 * By default, the assignments after a unary expression are the same as those after its operand expression.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
