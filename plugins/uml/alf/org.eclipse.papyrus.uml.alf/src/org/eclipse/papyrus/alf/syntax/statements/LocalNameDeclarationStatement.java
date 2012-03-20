package org.eclipse.papyrus.alf.syntax.statements;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.expressions.Expression;
import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;

public class LocalNameDeclarationStatement extends Statement {

	// Synthesized Properties
	public Expression expression ;
	public boolean hasMultiplicity = false ;
	public String name ;
	public QualifiedName typeName ;
	
	// Derived Properties
	public ElementReference type ;
	
	// Constraints
	/*
	 * The assignments after a local name declaration statement are the assignments before the statement plus a
	 * 	new assignment for the local name defined by the statement. The assigned source for the local name is
	 * 	the local name declaration statement. The local name has the type denoted by the type name if this is not
	 * 	empty and is untyped otherwise. If the statement has multiplicity, then the multiplicity of the local name
	 * 	is [0..*], otherwise it is [0..1].
	 */
	public void checkLocalNameDeclarationStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the expression of a local name declaration statement are the same as the
	 * 	assignments before the statement.
	 */
	public void checkLocalNameDeclarationStatementAssignmentsBefore() {
		
	}
	
	/*
	 * If a local name declaration statement does not have multiplicity, then the multiplicity of upper bound of
	 * 	the assigned expression must not be greater than 1.
	 */
	public void checkLocalNameDeclarationStatementExpressionMultiplicity() {
		
	}
	
	/*
	 * The local name in a local name declaration statement must be unassigned before the statement and
	 * 	before the expression in the statement. It must remain unassigned after the expression.
	 */
	public void checkLocalNameDeclarationStatementLocalName() {
		
	}
	
	/*
	 * If the type name in a local name declaration statement is not empty, then it must resolve to a nontemplate
	 * 	classifier and the expression must be assignable to that classifier.
	 */
	public void checkLocalNameDeclarationStatementType() {
		
	}
	
	/*
	 * The type of a local name declaration statement with a type name is the single classifier referent of the
	 * 	type name. Otherwise it is the type of the expression of the statement.
	 */
	public void checkLocalNameDeclarationStatementTypeDerivation() {
		
	}
	
}
