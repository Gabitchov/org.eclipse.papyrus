package org.eclipse.papyrus.alf.syntax.statements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;
import org.eclipse.papyrus.alf.syntax.expressions.Expression;

public class SwitchClause extends SyntaxElement {

	// Synthesized Properties
	public Block block ;
	public List<Expression> _case ;

	// Constraints
	
	/*
	 * The assignments before any case expression of a switch clause are the same as the assignments before
	 * 	the clause. The assignments before the block of a switch clause are the assignments after all case
	 * 	expressions.
	 */
	public void checkSwitchClauseAssignmentsBefore() {
		
	}
	
	/*
	 * If a name is unassigned before a switch clause, then it must be unassigned after all case expressions of
	 * 	the clause (i.e., new local names may not be defined in case expressions).
	 */
	public void checkSwitchClauseCaseLocalNames() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * The assignments after a switch clause are the assignments after the block of the switch clause.
	 */
	public List<AssignedSource> assignmentsAfter() {
		return new ArrayList<AssignedSource>() ;
	}
	
	/*
	 * The assignments before a switch clause are the assignments before any case expression of the clause.
	 */
	public List<AssignedSource> assignmentsBefore() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
