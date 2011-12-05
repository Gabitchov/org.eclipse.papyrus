package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;

public class AcceptStatement extends Statement {

	// Synthesized Properties
	public List<AcceptBlock> acceptBlock ;
	
	// Derived Properties
	public ElementReference behavior ;
	public boolean isSimple ;
	
	// Constraints
	
	/*
	 * If a name is assigned in any block of an accept statement, then the assigned source of the name after the
	 * 	accept statement is the accept statement itself.
	 */
	public void checkAcceptStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before any block of an accept statement are the assignments before the accept
	 * 	statement.
	 */
	public void checkAcceptStatementAssignmentsBefore() {
		
	}
	
	/*
	 * For a compound accept statement, a local name defined in an accept block has the accept block as its
	 * 	assigned source before the block associated with the accept block. The type of the local name is the
	 * 	effective common ancestor of the specified signals for that accept clause, if one exists, and it is untyped
	 * 	otherwise. However, the local name is considered unassigned after the accept statement.
	 */
	public void checkAcceptStatementCompoundAcceptLocalName() {
		
	}
	
	/*
	 * An accept statement can only be used within the definition of an active behavior or the classifier
	 * 	behavior of an active class.
	 */
	public void checkAcceptStatementContext() {
		
	}
	
	/*
	 * The enclosing statement for all statements in the blocks of all accept blocks of an accept statement is the
	 * 	accept statement.
	 */
	public void checkAcceptStatementEnclosedStatements() {
		
	}
	
	/*
	 * An accept statement is simple if it has exactly one accept block and that accept block does not have a
	 * 	block.
	 */
	public void checkAcceptStatementIsSimpleDerivation() {
		
	}
	
	/*
	 * Any name defined in an accept block of an accept statement must be unassigned before the accept
	 * 	statement.
	 */
	public void checkAcceptStatementNames() {
		
	}
	
	/*
	 * If a name is unassigned before an accept statement and assigned in any block of an accept statement,
	 * 	then it must be assigned in every block.
	 */
	public void checkAcceptStatementNewAssignments() {
		
	}
	
	/*
	 * The containing behavior of an accept statement must have receptions for all signals from all accept
	 * 	blocks of the accept statement. No signal may be referenced in more than one accept block of an accept
	 * 	statement.
	 */
	public void checkAcceptStatementSignals() {
		
	}
	
	/*
	 * A local name specified in the accept block of a simple accept statement has the accept statement as its
	 * 	assigned source after the accept statement. The type of the local name is the effective common ancestor
	 * 	of the specified signals, if one exists, and it is untyped otherwise.
	 */
	public void checkAcceptStatementSimpleAcceptLocalName() {
		
	}
	
}
