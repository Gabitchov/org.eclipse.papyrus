package org.eclipse.papyrus.alf.syntax.expressions;

public abstract class LiteralExpression extends Expression {

	// Constraints
	
	/*
	 * The multiplicity lower bound of a literal expression is always 1.
	 */
	public void checkLiteralExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a literal expression is given by the type of the literal, as defined for each subclass below.
	 */
	public void checkLiteralExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a literal expression is always 1.
	 */
	public void checkLiteralExpressionUpperDerivation() {
		
	}
	
}
