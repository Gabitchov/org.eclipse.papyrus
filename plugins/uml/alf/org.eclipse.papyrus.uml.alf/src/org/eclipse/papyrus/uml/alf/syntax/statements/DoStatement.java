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

import org.eclipse.papyrus.uml.alf.syntax.expressions.Expression;

public class DoStatement extends Statement {

	// Synthesized Properties
	public Block body ;
	public Expression condition ;
	
	// Constraints
	
	/*
	 * If the assigned source for a name after the condition expression is different than before the do statement,
	 * 	then the assigned source of the name after the do statement is the do statement. Otherwise it is the same
	 * 	as before the do statement.
	 */
	public void checkDoStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the block of a do statement are the same as the assignments before the do
	 * 	statement. The assignments before the condition expression of a do statement are the same assignments
	 * 	after the block.
	 */
	public void checkDoStatementAssignmentsBefore() {
		
	}
	
	/*
	 * The condition expression of a do statement must have type Boolean and a multiplicity upper bound of 1.
	 */
	public void checkDoStatementCondition() {
		
	}
	
	/*
	 * The enclosing statement for all statements in the body of a do statement are the do statement.
	 */
	public void checkDoStatementEnclosedStatements() {
		
	}
	
}
