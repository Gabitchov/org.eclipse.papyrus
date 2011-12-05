package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;
import org.eclipse.papyrus.alf.syntax.expressions.Expression;
import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;

public class LoopVariableDefinition extends SyntaxElement{

	// Synthesized Properties
	public Expression expression1 ;
	public Expression expression2 ;
	public boolean typeIsInferred = true ;
	public QualifiedName typeName ;
	public String variable ;
	
	// Derived Properties
	public List<AssignedSource> assignmentAfter ;
	public List<AssignedSource> assignmentBefore ;
	public boolean isCollectionConversion ;
	public boolean isFirst ;
	public ElementReference type ;
	
	// Constraints
	
	/*
	 * The assignments after a loop variable definition include the assignments after the expression (or
	 * 	expressions) of the definition plus a new assigned source for the loop variable itself. The assigned
	 * 	source for the loop variable is the loop variable definition. The multiplicity upper bound for the variable
	 * 	is 1. The multiplicity lower bound is 1 if the loop variable definition is the first in a for statement and 0
	 * 	otherwise. If collection conversion is not required, then the variable has the inferred or declared type
	 * 	from the definition. If collection conversion is required, then the variable has the argument type of the
	 * 	collection class.
	 */
	public void checkLoopVariableDefinitionAssignmentAfterDerivation() {
		
	}
	
	/*
	 * The assignments before the expressions of a loop variable definition are the assignments before the loop
	 * 	variable definition.
	 */
	public void checkLoopVariableDefinitionAssignmentsBefore() {
		
	}
	
	/*
	 * If the type of a loop variable definition is not inferred, then the first expression of the definition must
	 * 	have a type that conforms to the declared type.
	 */
	public void checkLoopVariableDefinitionDeclaredType() {
		
	}
	
	/*
	 * If a loop variable definition has two expressions, then both expressions must have type Integer and a
	 * 	multiplicity upper bound of 1, and no name may be newly assigned or reassigned in more than one of
	 * 	the expressions.
	 */
	public void checkLoopVariableDefinitionRangeExpressions() {
		
	}
	
	/*
	 * If the type of a loop variable is not inferred, then the variable has the type denoted by the type name, if it
	 * 	is not empty, and is untyped otherwise. If the type is inferred, them the variable has the same as the type
	 * 	of the expression in its definition.
	 */
	public void checkLoopVariableDefinitionTypeDerivation() {
		
	}
	
	/*
	 * If a loop variable definition has a type name, then this name must resolve to a non-template classifier.
	 */
	public void checkLoopVariableDefinitionTypeName() {
		
	}
	
	/*
	 * The variable name given in a loop variable definition must be unassigned after the expression or
	 * 	expressions in the definition.
	 */
	public void checkLoopVariableDefinitionVariable() {
		
	}
	
	/*
	 * Collection conversion is required for a loop variable definition if the type for the definition is the
	 * 	instantiation of a collection class and the multiplicity upper bound of the first expression is no greater
	 * 	than 1.
	 */
	public void checkLoopVariableIsCollectionConversionDerivation() {
		
	}
	
}
