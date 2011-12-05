package org.eclipse.papyrus.alf.syntax.statements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;
import org.eclipse.papyrus.alf.syntax.expressions.Expression;

public class NonFinalClause extends SyntaxElement {

	// Synthesized Properties
	public Block body ;
	public Expression condition ;

	// Constraints
	
	/*
	 * The assignments before the body of a non-final clause are the assignments after the condition.
	 */
	public void checkNonFinalClauseAssignmentsBeforeBody() {
		
	}
	
	/*
	 * If a name is unassigned before the condition expression of a non-final clause, then it must be unassigned
	 * 	after that expression (i.e., new local names may not be defined in the condition).
	 */
	public void checkNonFinalClauseConditionLocalNames() {
		
	}
	
	/*
	 * The condition of a non-final clause must have type Boolean and a multiplicity upper bound no greater
	 * 	than 1.
	 */
	public void checkNonFinalClauseConditionType() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * The assignments after a non-final clause are the assignments after the block of the clause.
	 */
	public List<AssignedSource> assignmentsAfter() {
		return new ArrayList<AssignedSource>() ;
	}
	
	/*
	 * The assignments before a non-final clause are the assignments before the condition of the clause.
	 */
	public List<AssignedSource> assignmentsBefore() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
