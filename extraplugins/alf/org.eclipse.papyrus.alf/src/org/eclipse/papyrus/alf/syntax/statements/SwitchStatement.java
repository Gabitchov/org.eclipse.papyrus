package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.expressions.Expression;

public class SwitchStatement extends Statement {

	// Synthesized Properties
	public Block defaultClause ;
	public Expression expression ;
	public List<SwitchClause> nonDefaultClause ;
	
	// Derived Properties
	public boolean isAssured ;
	public boolean isDetermined ;
	
	// Constraints
	
	/*
	 * If a switch statement does not have a final default clause, then any name that is unassigned before the
	 * 	switch statement is unassigned after the switch statement. If a switch statement does have a final default
	 * 	clause, then any name that is unassigned before the switch statement and is assigned after any one clause
	 * 	of the switch statement must also be assigned after every other clause. The type of such names after the
	 * 	switch statement is the effective common ancestor of the types of the name in each clause with a
	 * 	multiplicity lower bound that is the minimum of the lower bound for the name in each clause and a
	 * 	multiplicity upper bound that is the maximum for the name in each clause.
	 */
	public void checkSwitchStatementAssignments() {
		
	}
	
	/*
	 * If a name has an assigned source after any clause of a switch statement that is different than before that
	 * 	clause (including newly defined names), the assigned source after the switch statement is the switch
	 * 	statement. Otherwise, the assigned source of a name after the switch statement is the same as before the
	 * 	switch statement.
	 */
	public void checkSwitchStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before all clauses of a switch statement are the same as the assignments before the
	 * 	switch statement.
	 */
	public void checkSwitchStatementAssignmentsBefore() {
		
	}
	
	/*
	 * The same local name may not be assigned in more than one case expression in a switch statement.
	 */
	public void checkSwitchStatementCaseAssignments() {
		
	}
	
	
	public void checkSwitchStatementEnclosedStatements() {
		
	}
	
	public void checkSwitchStatementExpression() {
		
	}
	
	/*
	 * An switch statement is assured if it has an @assured annotation.
	 */
	public void checkSwitchStatementIsAssuredDerivation() {
		
	}
	
	/*
	 * An switch statement is determined if it has an @determined annotation.
	 */
	public void checkSwitchStatementIsDeterminedDerivation() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * In addition to an @isolated annotation, a switch statement may have @assured and @determined
	 * 	annotations. They may not have arguments.
	 */
	public boolean annotationAllowed(Annotation annotation) {
		return false ;
	}
	
}
