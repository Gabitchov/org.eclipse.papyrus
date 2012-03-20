package org.eclipse.papyrus.alf.syntax.expressions;

public class ThisExpression extends Expression {

	// Constraints
	/*
	 * The multiplicity lower bound of a this expression is always 1.
	 */
	public void checkThisExpressionLowerDerivation() {
		
	}
	
	/*
	 * The static type of a this expression is the statically determined context classifier for the context in which
	 * 	the this expression occurs.
	 */
	public void checkThisExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a this expression is always 1.
	 */
	public void checkThisExpressionUpperDerivation() {
		
	}
	
}
