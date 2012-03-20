package org.eclipse.papyrus.alf.syntax.statements;

public class BreakStatement extends Statement {

	// Derived Properties
	public Statement target ;
	
	// Constraints
	/*
	 * The target of a break statement may not have a @parallel annotation.
	 */
	public void checkBreakStatementNonparallelTarget() {
		
	}
	
	/*
	 * The target of a break statement is the innermost switch, while, do or for statement enclosing the break
	 * 	statement.
	 */
	public void checkBreakStatementTargetDerivation() {
		
	}
	
	// Helper Operations
	
	/*
	 * A break statement may not have any annotations.
	 */
	public boolean annotationAllowed (Annotation annotation) {
		return false ;
	}
	
	
}
