package org.eclipse.papyrus.alf.syntax.expressions;

public class NameLeftHandSide extends LeftHandSide {

	// Synthesized Properties
	public QualifiedName target ;
	
	// Constraints
	
	/*
	 * The assignments after a name left-hand side are the same as the assignments before.
	 */
	public void checkNameLeftHandSideAssignmentAfterDerivation() {
		
	}
	
	/*
	 * If a name left-hand side has an index, then the target name must already have an assigned source and the
	 * 	assignments before the index expression are the assignments before the left-hand side.
	 */
	public void checkNameLeftHandSideAssignmentsBefore() {
		
	}
	
	/*
	 * The target of a name left hand side may not already have an assigned source that is a loop variable
	 * 	definition, an annotation, a sequence expansion expression or a parameter that is an in parameter.
	 */
	public void checkNameLeftHandSideTargetAssignment() {
		
	}
	
	
}
