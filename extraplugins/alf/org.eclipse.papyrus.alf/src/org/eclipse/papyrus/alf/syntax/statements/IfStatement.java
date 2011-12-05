package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

public class IfStatement extends Statement {

	// Synthesized Properties
	public Block finalClause ;
	public List<ConcurrentClauses> nonFinalClauses ;

	// Derived Properties
	public boolean isAssured ;
	public boolean isDetermined ;
	
	// Constraints
	
	/*
	 * If an if statement does not have a final else clause, then any name that is unassigned before the if
	 * 	statement is unassigned after the if statement. If an if statement does have a final else clause, then any
	 * 	name that is unassigned before the if statement and is assigned after any one clause of the if statement
	 * 	must also be assigned after every other clause. The type of such names after the if statement is the
	 * 	effective common ancestor of the types of the name in each clause with a multiplicity lower bound that
	 * 	is the minimum of the lower bound for the name in each clause and a multiplicity upper bound that is the
	 * 	maximum for the name in each clause. For a name that has an assigned source after any clause of an if
	 * 	statement that is different than before that clause, then the assigned source after the if statement is the if
	 * 	statement. Otherwise, the assigned source of a name after the if statement is the same as before the if
	 * 	statement.
	 */
	public void checkIfStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before all the non-final clauses of an if statement are the same as the assignments
	 * 	before the if statement. If the statement has a final clause, then the assignments before that clause are
	 * 	also the same as the assignments before the if statement.
	 */
	public void checkIfStatementAssignmentsBefore() {
		
	}
	
	/*
	 * The enclosing statement of all the statements in the bodies of all non-final clauses and in the final clause
	 * 	(if any) of an if statement is the if statement.
	 */
	public void checkIfStatementEnclosedStatements() {
		
	}
	
	/*
	 * An if statement is assured if it has an @assured annotation.
	 */
	public void checkIfStatementIsAssuredDerivation() {
		
	}
	
	/*
	 * An if statement is determined if it has an @determined annotation.
	 */
	public void checkIfStatementIsDeterminedDerivation() {
		
	}
	
	
	// Helper Operations
	/*
	 * In addition to an @isolated annotation, an if statement may have @assured and @determined
	 * 	annotations. They may not have arguments.
	 */
	public boolean annotationAllowed (Annotation annotation) {
		return false ;
	}
	
}
