package org.eclipse.papyrus.alf.syntax.expressions;

public class NaturalLiteralExpression extends LiteralExpression {

	// Synthesized Properties
	public String image ;
	
	// Constraints
	
	/*
	 * The type of a natural literal is the Alf library type Natural.
	 * 	NOTE: If the context of a natural literal expression unambiguously requires either an Integer or an
	 * 	UnlimitedNatural value, then the result of the literal expression is implicitly downcast to the required
	 * 	type. If the context is ambiguous, however, than an explicit cast to Integer or UnlimitedNatural must be
	 * 	used.
	 */
	public void checkNaturalLiteralExpressionTypeDerivation() {
		
	}
	
}
