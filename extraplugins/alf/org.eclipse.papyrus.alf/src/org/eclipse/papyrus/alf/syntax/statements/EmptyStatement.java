package org.eclipse.papyrus.alf.syntax.statements;

public class EmptyStatement extends Statement {

	// Constraints
	
	/*
	 * The assignments after and empty statement are the same as the assignments before the statement.
	 */
	public void checkEmptyStatementAssignmentsAfter() {
		
	}
	
	// Helper Operations
	public boolean annotationAllowed (Annotation annotation) {
		return false ;
	}
	
}
