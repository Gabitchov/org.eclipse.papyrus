package org.eclipse.papyrus.alf.syntax.statements;

public class InLineStatement extends Statement {

	// Synthesized Properties
	public String code ;
	public String language ;
	
	// Constraints
	
	/*
	 * The assignments after an in-line statement are the same as the assignments before the statement.
	 */
	public void checkInLineStatementAssignmentsAfter() {
		
	}
	
	
}
