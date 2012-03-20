package org.eclipse.papyrus.alf.syntax.expressions;

import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class NamedExpression extends SyntaxElement {

	// Synthesized Properties
	public Expression expression ;
	public Expression index ;
	public String name ;
	
	// Derived Properties
	public boolean isBitStringConverstion ;
	public boolean isCollectionConversion ;
	
	// Constraints
	
	/*
	 * Bit string conversion is required if the type of the type of the corresponding parameter is BitString, or a
	 * 	collection class instantiated with a BitString type, and the type of the argument expression is not
	 * 	BitString.
	 */
	public void checkNamedExpressionIsBitStringConversionDerivation() {
		
	}
	
	/*
	 * Collection conversion is required if the type of the corresponding parameter is a collection class and the
	 * 	type of the argument expression is not.
	 */
	public void checkNamedExpressionIsCollectionConversionDerivation() {
		
	}
	
}
