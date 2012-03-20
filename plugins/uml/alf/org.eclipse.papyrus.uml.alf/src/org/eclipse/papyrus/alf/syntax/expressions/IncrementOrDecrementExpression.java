package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.ElementReference;

public class IncrementOrDecrementExpression extends Expression {
	
	// Synthesized Properties
	public boolean isPrefix ;
	public LeftHandSide operand ;

	// Derived Properties
	public AssignedSource assignment ;
	public Expression expression ;
	public ElementReference feature ;
	public boolean isDataValueUpdate ;
	public boolean isFeature ;
	public boolean isIndexed ;

	// Constraints
	
	/*
	 * If the operand of an increment or decrement expression is a name, then the assignment for the
	 * 	expression is a new assigned source for the name with the expression as the source.
	 */
	public void checkIncrementOrDecrementExpressionAssignment() {
		
	}
	
	/*
	 * The assignments before the operand of an increment or decrement expression are the same as those
	 * 	before the increment or decrement expression.
	 */
	public void checkIncrementOrDecrementExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * The effective expression for the operand of an increment or decrement expression is the operand treated
	 * 	as a name expression, property access expression or sequence access expression, as appropriate for
	 * 	evaluation to obtain the original value to be updated.
	 */
	public void checkIncrementOrDecrementExpressionExpressionDerivation() {
		
	}
	
	/*
	 * If the operand of an increment or decrement expression is a feature, then the referent for the operand.
	 */
	public void checkIncrementOrDecrementExpressionFeature() {
		
	}
	
	/*
	 * An increment or decrement expression is a data value update if its operand is an attribute of a data value
	 * 	held in a local name or parameter.
	 */
	public void checkIncrementOrDecrementExpressionIsDataValueUpdate() {
		
	}
	
	/*
	 * An increment or decrement expression has a feature as its operand if the operand is a kind of
	 * 	FeatureLeftHandSide.
	 */
	public void checkIncrementOrDecrementExpressionIsFeatureDerivation() {
		
	}
	
	/*
	 * An increment or decrement expression is indexed if its operand is indexed.
	 */
	public void checkIncrementOrDecrementExpressionIsIndexedDerivation() {
		
	}
	
	/*
	 * An increment or decrement expression has the same multiplicity lower bound as its operand expression.
	 */
	public void checkIncrementOrDecrementExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operand expression must have type Integer and a multiplicity upper bound of 1.
	 */
	public void checkIncrementOrDecrementExpressionOperand() {
		
	}
	
	/*
	 * An increment or decrement expression has type Integer.
	 */
	public void checkIncrementOrDecrementExpressionTypeDerivation() {
		
	}
	
	/*
	 * An increment or decrement expression has a multiplicity upper bound of 1.
	 */
	public void checkIncrementOrDecrementExpressionUpperDerivation() {
		
	}
	
	// Helper Operations
	
	/*
	 * The assignments after an increment and decrement expression include all those after its operand
	 * 	expression. Further, if the operand expression, considered as a left hand side, is a local name, then this is
	 * 	reassigned.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
