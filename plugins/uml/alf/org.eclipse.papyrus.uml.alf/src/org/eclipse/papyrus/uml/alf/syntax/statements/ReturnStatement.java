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
package org.eclipse.papyrus.uml.alf.syntax.statements;

import org.eclipse.papyrus.uml.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.uml.alf.syntax.expressions.Expression;

public class ReturnStatement extends Statement {

	// Synthesized Properties
	public Expression expression ;
	
	// Derived Properties
	public ElementReference behavior ;
	
	// Constraints
	
	/*
	 * The assignments after a return statement are the same as the assignments after the expression of the
	 * 	return statement.
	 */
	public void checkReturnStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the expression of a return statement are the same as the assignments before the
	 * 	statement.
	 */
	public void checkReturnStatementAssignmentsBefore() {
		
	}
	
	/*
	 * The behavior containing the return statement must have a return parameter. The expression of the return
	 * 	statement must be assignable to that return parameter.
	 */
	public void checkReturnStatementContext() {
		
	}
	
	
}
