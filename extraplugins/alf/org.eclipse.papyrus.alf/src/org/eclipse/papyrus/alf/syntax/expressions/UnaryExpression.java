package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;

public class UnaryExpression extends Expression {

	// Synthesized Properties
	public Expression operand ;
	public String operator ;
	
	// Constraints
	
	/*
	 * The assignments before the operand of a unary expression are the same as those before the unary
	 * 	expression.
	 */
	public void checkUnaryExpressionAssignmentsBefore() {
		
	}
	
	//Helper Operations
	/*
	 * By default, the assignments after a unary expression are the same as those after its operand expression.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
