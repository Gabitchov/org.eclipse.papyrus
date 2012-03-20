package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

public class ForStatement extends Statement{

	// Synthesized Properties
	public Block body ; 
	public List<LoopVariableDefinition> variableDefinition ;
	
	// Derived Properties
	public boolean isParallel ;
	
	// Constraints
	
	/*
	 * The loop variables are unassigned after a for statement. Other than the loop variables, if the assigned
	 * 	source for a name after the body of a for statement is the same as after the for variable definitions, then
	 * 	the assigned source for the name after the for statement is the same as after the for variable definitions.
	 * 	If a name is unassigned after the for variable definitions, then it is unassigned after the for statement
	 * 	(even if it is assigned in the body of the for statement). If, after the loop variable definitions, a name has
	 * 	an assigned source, and it has a different assigned source after the body of the for statement, then the
	 * 	assigned source after the for statement is the for statement itself.
	 */
	public void checkForStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before a loop variable definition in a for statement are the same as before the for
	 * 	statement. The assignments before the body of the statement include all the assignments before the
	 * 	statement plus any new assignments from the loop variable definitions, except that, if the statement is
	 * 	parallel, the assigned sources of any names given in @parallel annotations are changed to be the for
	 * 	statement itself.
	 */
	public void checkForStatementAssignmentsBefore() {
		
	}
	
	/*
	 * The enclosing statement for all statements in the body of a for statement are the for statement.
	 */
	public void checkForStatementEnclosedStatements() {
		
	}
	
	/*
	 * A for statement is parallel if it has a @parallel annotation.
	 */
	public void checkForStatementIsParallelDerivation() {
		
	}
	
	/*
	 * The assigned sources for loop variables after the body of a for statement must be the for statement (the
	 * 	same as before the body).
	 */
	public void checkForStatementLoopVariables() {
		
	}
	
	/*
	 * A @parallel annotation of a for statement may include a list of names. Each such name must be already
	 * 	assigned after the loop variable definitions of the for statement, with a multiplicity of [0..*]. These
	 * 	names may only be used within the body of the for statement as the first argument to for the
	 * 	CollectionFunctions::add behavior.
	 */
	public void checkForStatementParallelAnnotationNames() {
		
	}
	
	/*
	 * If, after the loop variable definitions of a parallel for statement, a name has an assigned source, then it
	 * 	must have the same assigned source after the block of the for statement. Other than for names defined in
	 * 	the @parallel annotation of the for statement, the assigned source for such names is the same after the
	 * 	for statement as before it. Any names defined in the @parallel annotation have the for statement itself as
	 * 	their assigned source after the for statement. Other than names given in the @parallel annotation, if a
	 * 	name is unassigned after the loop variable definitions, then it is considered unassigned after the for
	 * 	statement, even if it is assigned in the block of the for statement.
	 */
	public void checkForStatementParallelAssignmentsAfter() {
		
	}
	
	/*
	 * The isFirst attribute of the first loop variable definition for a for statement is true while the isFirst
	 * 	attribute if false for any other definitions.
	 */
	public void checkForStatementVariableDefinitions() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * In addition to an @isolated annotation, a for statement may have a @parallel annotation.
	 */
	public boolean annotationAllowed (Annotation annotation) {
		return false ;
	}
	
}
