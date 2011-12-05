package org.eclipse.papyrus.alf.syntax.expressions;

public class EqualityExpression extends BinaryExpression {

	// Derived Properties
	public boolean isNegated ;

	// Constraints
	
	/*
	 * An equality expression is negated if its operator is "!=".
	 */
	public void checkEqualityExpressionIsNegatedDerivation() {
		
	}
	
	/*
	 * An equality expression has a multiplicity lower bound of 1.
	 */
	public void checkEqualityExpressionLowerDerivation() {
		
	}
	
	/*
	 * An equality expression has type Boolean.
	 */
	public void checkEqualityExpressionTypeDerivation() {
		
	}
	
	/*
	 * An equality expression has a multiplicity upper bound of 1.
	 */
	public void checkEqualityExpressionUpperDerivation() {
		
	}
	
}
