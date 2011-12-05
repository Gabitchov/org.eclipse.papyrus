package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;

public class ConditionalTestExpression extends Expression {
	
	// Synthesized Properties
	public Expression operand1  ;
	public Expression operand2 ;
	public Expression operand3 ;

	// Constraints

	/*
	 * If a name is unassigned after the first operand expression and has an assigned source after one of the
	 * 	other operand expression, then it must have an assigned source after both of those expressions.
	 */
	public void checkConditionalTestExpressionAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the first operand expression of a conditional-test expression are the same as
	 * 	those before the conditional-test expression. The assignments before the second and third operand
	 * 	expressions are the same as those after the first operand expression.
	 */
	public void checkConditionalTestExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * The first operand expression of a conditional-test expression must be of type Boolean and have a
	 * 	multiplicity upper bound of 1.
	 */
	public void checkConditionalTestExpressionCondition() {
		
	}
	
	/*
	 * The multiplicity lower bound of a conditional-test operator expression is the minimum of the
	 * 	multiplicity lower bounds of its second and third operand expressions.
	 */
	public void checkConditionalTestExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a conditional-test operator expression is the effective common ancestor (if one exists) of the
	 * 	types of its second and third operand expressions.
	 */
	public void checkConditionalTestExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a conditional-test operator expression is the maximum of the
	 * 	multiplicity upper bounds of its second and third operand expressions.
	 */
	public void checkConditionalTestExpressionUpperDerivation() {
		
	}
	
	// Helper Operations
	
	/*
	 * Returns unchanged all assignments for local names that are not reassigned in either the second or third
	 * 	operand expressions. Any local names that have different assignments after the second and third operand
	 * 	expressions are adjusted to have the conditional-test expression as their assigned source.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
