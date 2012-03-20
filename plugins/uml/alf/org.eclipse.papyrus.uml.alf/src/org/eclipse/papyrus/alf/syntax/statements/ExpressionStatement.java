package org.eclipse.papyrus.alf.syntax.statements;

import org.eclipse.papyrus.alf.syntax.expressions.Expression;

public class ExpressionStatement extends Statement {

	// Synthesized Properties
	public Expression expression ;
	
	// Constraints
	
	/*
	 * The assignments after an expression statement are the same as the assignments after its expression.
	 */
	public void checkExpressionStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the expression of an expression statement are the same as the assignments
	 * 	before the statement.
	 */
	public void checkExpressionStatementAssignmentsBefore() {
		
	}
	
}
