package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;

public abstract class BinaryExpression extends Expression {

	// Synthesized Properties
	public Expression operand1 ;
	public Expression operand2 ;
	public String operator ;
	
	// Constraints
	
	/*
	 * The assignments in the operand expressions of a binary expression must be valid (as determined by the
	 * 	validateAssignments helper operation).
	 */
	public void checkBinaryExpressionOperandAssignments() {
		
	}
	
	/*
	 * The operands of a binary expression must both have a multiplicity upper bound of 1.
	 */
	public void checkBinaryExpressionOperandMultiplicity() {
		
	}
	
	// Helper Operations
	
	/*
	 * The assignments after a binary expression include all the assignments before the expression that are not
	 * 	reassigned in either operand expression, plus the new assignments from each of the operand expressions.
	 */
	public List<AssignedSource> updateAssignments ( ) {
		return new ArrayList<AssignedSource>() ;
	}
	
	/*
	 * In general the assignments before the operand expressions of a binary expression are the same as those
	 * 	before the binary expression and, if an assignment for a name is changed in one operand expression,
	 * 	then the assignment for that name may not change in the other operand expression. (This is overridden
	 * 	for conditional logical expressions.)
	 */
	public boolean validateAssignments ( ) {
		return false ;
	}
	
}
