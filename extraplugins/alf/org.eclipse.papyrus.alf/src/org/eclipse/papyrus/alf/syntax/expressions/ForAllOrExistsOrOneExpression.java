package org.eclipse.papyrus.alf.syntax.expressions;

public class ForAllOrExistsOrOneExpression extends SequenceExpansionExpression {

	// Constraints
	
	/*
	 * The argument of a forAll, exists or one expression must have type Boolean and a multiplicity upper
	 * 	bound of 1.
	 */
	public void checkForAllOrExistOrOneExpressionArgument() {
		
	}
	
	/*
	 * A forAll, exists or one expression has a multiplicity lower bound of 1.
	 */
	public void checkForAllOrExistOrOneExpressionLowerDerivation() {
		
	}
	
	/*
	 * A forAll, exists or one expression has the type Boolean.
	 */
	public void checkForAllOrExistOrOneExpressionTypeDerivation() {
		
	}
	
	/*
	 * A forAll, exists or one expression has a multiplicity upper bound of 1.
	 */
	public void checkForAllOrExistOrOneExpressionUpperDerivation() {
		
	}
	
}
