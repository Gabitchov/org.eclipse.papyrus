package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class ConcurrentClauses extends SyntaxElement {

	// Synthesized Properties
	public List<NonFinalClause> clause ;
	
	// Constraints
	/*
	 * The assignments before each of the clauses in a set of concurrent clauses are the same as the
	 * 	assignments before the concurrent clauses.
	 */
	public void checkConcurrentClausesAssignmentsBefore() {
		
	}
	
	/*
	 * The same name may not be assigned in more than one conditional expression within the same
	 * 	concurrent set of clauses.
	 */
	public void checkConcurrentClausesConditionAssignments() {
		
	}
	
}
