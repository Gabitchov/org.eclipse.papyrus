package org.eclipse.papyrus.alf.syntax.statements;

public class BlockStatement extends Statement {

	// Synthesized Properties
	public Block block ;
	
	// Derived Properties
	public boolean isParallel ;
	
	// Constraints
	
	/*
	 * The assignments after a block statement are the same as the assignments after the block of the block
	 * 	statement.
	 */
	public void checkBlockStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the block of a block statement are the same as the assignments before the block
	 * 	statement.
	 */
	public void checkBlockStatementAssignmentsBefore() {
		
	}
	
	/*
	 * The enclosing statement for all the statements in the block of a block statement is the block statement.
	 */
	public void checkBlockStatementEnclosedStatements() {
		
	}
	
	/*
	 * A block statement is parallel if it has a @parallel annotation.
	 */
	public void checkBlockStatementIsParallelDerivation() {
		
	}
	
	/*
	 * In a parallel block statement, any name assigned in one statement of the block may not be further
	 * 	assigned in any subsequent statement in the same block.
	 */
	public void checkBlockStatementParallelAssignments() {
		
	}
	
	
	// Helper Operations
	/*
	 * In addition to an @isolated annotation, a block statement may have a @parallel annotation. It may not
	have any arguments.
	 */
	public boolean annotationAllowed (Annotation annotation ) {
		return false ;
	}
	
}
