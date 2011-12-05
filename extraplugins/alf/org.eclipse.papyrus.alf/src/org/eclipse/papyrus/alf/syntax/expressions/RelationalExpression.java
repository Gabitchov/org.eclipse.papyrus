package org.eclipse.papyrus.alf.syntax.expressions;

public class RelationalExpression extends BinaryExpression {

	// Derived Properties
	public boolean isUnlimitedNatural ;
	
	// Constraints
	
	/*
	 * A relational expression has a multiplicity lower bound of 0 if the lower bound if either operand
	 * 	expression is 0 and 1 otherwise.
	 */
	public void checkRelationalExpressionIsLowerDerivation() {
		
	}
	
	/*
	 * The type of a relational expression is Boolean.
	 */
	public void checkRelationalExpressionIsTypeDerivation() {
		
	}
	
	/*
	 * A relational expression is an UnlimitedNatural comparison if either one of its operands has type
	 * 	UnlimitedNatural.
	 */
	public void checkRelationalExpressionIsUnlimitedNaturalDerivation() {
		
	}
	
	/*
	 * A relational expression has a multiplicity upper bound of 1.
	 */
	public void checkRelationalExpressionIsUpperDerivation() {
		
	}
	
	/*
	 * The operand expressions for a comparison operator must have type Integer, UnlimitedNatural or
	 * 	Natural. However, it is not allowed to have one operand expression be Integer and the other be
	 * 	UnlimitedNatural.
	 */
	public void checkRelationalExpressionOperandTypes() {
		
	}
	
	
}
