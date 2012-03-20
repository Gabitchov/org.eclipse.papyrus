package org.eclipse.papyrus.alf.syntax.statements;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.expressions.Expression;

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
