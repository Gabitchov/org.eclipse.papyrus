package org.eclipse.papyrus.alf.syntax.expressions;

public class CollectOrIterateExpression extends SequenceExpansionExpression {

	// Constraints
	
	/*
	 * A collect or iterate expression has a multiplicity lower bound that is the product of the bounds of its
	 * 	primary and argument expressions.
	 */
	public void checkCollectOrIterateExpressionLowerDerivation() {
		
	}
	
	/*
	 * A collect or iterate expression has the same type as its argument expression.
	 */
	public void checkCollectOrIterateExpressionTypeDerivation() {
		
	}
	
	/*
	 * A collect or iterate expression has a multiplicity upper bound that is the product of the bounds of its
	 * 	primary and argument expressions.
	 */
	public void checkCollectOrIterateExpressionUpperDerivation() {
		
	}
	
}
