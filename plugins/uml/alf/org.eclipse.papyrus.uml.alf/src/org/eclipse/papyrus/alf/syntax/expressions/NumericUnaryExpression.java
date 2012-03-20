package org.eclipse.papyrus.alf.syntax.expressions;

public class NumericUnaryExpression extends UnaryExpression {

	// Constraints
	
	/*
	 * A numeric unary expression has the same multiplicity lower bound as its operand expression.
	 */
	public void checkNumericUnaryExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operand expression must have type Integer and a multiplicity upper bound of 1.
	 */
	public void checkNumericUnaryExpressionOperand() {
		
	}
	
	/*
	 * A numeric unary expression must have type Integer.
	 */
	public void checkNumericUnaryExpressionTypeDerivation() {
		
	}
	
	/*
	 * A numeric unary expression has a multiplicity upper bound of 1.
	 */
	public void checkNumericUnaryExpressionUpperDerivation() {
		
	}
	
	
}
