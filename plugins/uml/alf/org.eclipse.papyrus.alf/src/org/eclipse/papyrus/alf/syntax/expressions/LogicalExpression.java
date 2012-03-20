package org.eclipse.papyrus.alf.syntax.expressions;

public class LogicalExpression extends BinaryExpression {

	// Derived Properties
	public boolean isBitStringConversion1 ;
	public boolean isBitStringConversion2 ;
	public boolean isBitWise ;
	
	// Constraints
	
	/*
	 * BitString conversion is required if the first operand expression of a shift expression has type Integer.
	 */
	public void checkLogicalExpressionIsBitStringConversion1Derivation() {
		
	}
	
	/*
	 * BitString conversion is required if the second operand expression of a shift expression has type Integer.
	 */
	public void checkLogicalExpressionIsBitStringConversion2Derivation() {
		
	}
	
	/*
	 * A logical expression is bit-wise if the type of its first operand is not Boolean.
	 */
	public void checkLogicalExpressionIsBitWiseDerivation() {
		
	}
	
	/*
	 * A logical expression has a multiplicity lower bound of 0 if the lower bound if either operand expression
	 * 	is 0 and 1 otherwise.
	 */
	public void checkLogicalExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operands of a logical expression must have type Boolean.
	 */
	public void checkLogicalExpressionOperands() {
		
	}
	
	/*
	 * A logical expression has type Boolean.
	 */
	public void checkLogicalExpressionTypeDerivation() {
		
	}
	
	/*
	 * A logical expression has a multiplicity upper bound of 1.
	 */
	public void checkLogicalExpressionUpperDerivation() {
		
	}
	
}
