package org.eclipse.papyrus.alf.syntax.expressions;

public class BooleanUnaryExpression extends UnaryExpression {

	// Constraints
	
	/*
	 * A Boolean unary expression has the same multiplicity lower bound as its operand expression.
	 */
	public void checkBooleanUnaryExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operand expression of a Boolean unary expression must have type Boolean and a multiplicity upper
	 * 	bound of 1.
	 */
	public void checkBooleanUnaryExpressionOperand() {
		
	}
	
	/*
	 * A Boolean unary expression has type Boolean.
	 */
	public void checkBooleanUnaryExpressionTypeDerivation() {
		
	}
	
	/*
	 * A Boolean unary expression has a multiplicity upper bound of 1.
	 */
	public void checkBooleanUnaryExpressionUpperDerivation() {
		
	}
	
}
