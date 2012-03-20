package org.eclipse.papyrus.alf.syntax.statements;

import org.eclipse.papyrus.alf.syntax.expressions.Expression;

public class WhileStatement extends Statement {

	// Synthesized Properties
	public Block body ;
	public Expression condition ;
	
	// Constraints
	
	/*
	 * If a name is assigned before the block, but the assigned source for the name after the block is different
	 * 	than before the block, then the assigned source of the name after the while statement is the while
	 * 	statement. Otherwise it is the same as before the block. If a name is unassigned before the block of a
	 * 	while statement, then it is unassigned after the while statement, even if it is assigned after the block.
	 */
	public void checkWhileStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the condition expression of a while statement are the same as the assignments
	 * 	before the while statement. The assignments before the block of the while statement are the same as the
	 * 	assignments after the condition expression.
	 */
	public void checkWhileStatementAssignmentsBefore() {
		
	}
	
	/*
	 * The condition expression of a while statement must have type Boolean and a multiplicity upper bound of
	 * 	1.
	 */
	public void checkWhileStatementCondition() {
		
	}
	
	/*
	 * The enclosing statement for all statements in the body of a while statement are the while statement.
	 */
	public void checkWhileStatementEnclosedStatements() {
		
	}
	
	
}
