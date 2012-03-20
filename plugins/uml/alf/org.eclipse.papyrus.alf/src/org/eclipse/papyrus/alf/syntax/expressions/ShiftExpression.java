package org.eclipse.papyrus.alf.syntax.expressions;

public class ShiftExpression extends BinaryExpression {

	// Derived Properties
	public boolean isBitStringConversion ;

	// Constraints
	
	/*
	 * BitString conversion is required if the first operand expression of a shift expression has type Integer.
	 */
	public void checkShiftExpressionIsBitStringConversionDerivation() {
		
	}
	
	/*
	 * A shift expression has a multiplicity lower bound of 0 if the lower bound if either operand expression is
	 * 0 and 1 otherwise.
	 */
	public void checkShiftExpressionLowerDerivation() {
		
	}
	
	/*
	 * The operands of a shift expression must have type BitString or Integer.
	 */
	public void checkShiftExpressionOperands() {
		
	}
	
	/*
	 * A shift expression has type BitString.
	 */
	public void checkShiftExpressionTypeDerivation() {
		
	}
	
	/*
	 * A shift expression has a multiplicity upper bound of 1.
	 */
	public void checkShiftExpressionUpperDerivation() {
		
	}
	
	
}
