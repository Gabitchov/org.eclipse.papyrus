package org.eclipse.papyrus.alf.syntax.expressions;

public class SequenceAccessExpression extends Expression {

	// Synthesized Properties
	public Expression index ;
	public Expression primary ;
	
	// Constraints
	
	/*
	 * The multiplicity upper bound of the index of a sequence access expression must be 1.
	 */
	public void checkSequenceAccessExpressionIndexMultiplicity() {
		
	}
	
	/*
	 * The type of the index of a sequence access expression must be Integer.
	 */
	public void checkSequenceAccessExpressionIndexType() {
		
	}
	
	/*
	 * The multiplicity lower bound of a sequence access expression is 0.
	 */
	public void checkSequenceAccessExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a sequence access expression is the same as the type of its primary expression.
	 */
	public void checkSequenceAccessExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a sequence access expression is 1.
	 */
	public void checkSequenceAccessExpressionUpperDerivation() {
		
	}
	
}
