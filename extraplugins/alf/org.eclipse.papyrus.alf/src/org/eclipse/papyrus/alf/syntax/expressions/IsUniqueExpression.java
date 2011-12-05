package org.eclipse.papyrus.alf.syntax.expressions;

public class IsUniqueExpression extends SequenceExpansionExpression {

	// Constraints
	
	/*
	 * The argument of an isUnique expression must have a multiplicity upper bound of 1.
	 */
	public void checkIsUniqueExpressionExpressionArgument() {
		
	}
	
	/*
	 * An isUnique expression has a multiplicity lower bound of 1.
	 */
	public void checkIsUniqueExpressionLowerDerivation() {
		
	}
	
	/*
	 * An isUnique expression has the type Boolean.
	 */
	public void checkIsUniqueExpressionTypeDerivation() {
		
	}
	
	/*
	 * An isUnique expression has a multiplicity upper bound of 1.
	 */
	public void checkIsUniqueExpressionUpperDerivation() {
		
	}
	
	
}
