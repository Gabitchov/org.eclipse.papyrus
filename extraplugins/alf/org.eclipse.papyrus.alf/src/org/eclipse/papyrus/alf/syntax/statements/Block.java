package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class Block extends SyntaxElement {

	// Synthesized Properties
	public List<Statement> statement ;
	
	// Derived Properties
	public List<AssignedSource> assignmentAfter ;
	public List<AssignedSource> assignmentBefore ;
	
	// Constraints
	
	/*
	 * If a block is not empty, then the assignments after the block are the same as the assignments after the
	 * 	last statement of the block. Otherwise they are the same as the assignments before the block.
	 */
	public void checkBlockAssignmentAfterDerivation() {
		
	}
	
	/*
	 * The assignments before each statement in a block other than the first are the same as the assignments
	 * 	after the previous statement.
	 */
	public void checkBlockAssignmentsBeforeStatements() {
		
	}
	
	
}
