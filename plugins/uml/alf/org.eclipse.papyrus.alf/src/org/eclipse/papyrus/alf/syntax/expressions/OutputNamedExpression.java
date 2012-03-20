package org.eclipse.papyrus.alf.syntax.expressions;

public class OutputNamedExpression extends NamedExpression {

	// Derived Properties
	public LeftHandSide leftHandSide ; 
	
	// Constraints
	
	/*
	 * The argument for an output parameter must be either be null, a name expression, a property access
	 * 	expression, or a sequence access expression whose primary expression is a name expression or a
	 * 	property access expression.
	 */
	public void checkOutputNamedExpressionForm() {
		
	}
	
	/*
	 * The equivalent left-hand side for an output named expression depends on the kind of expression. If the
	 * 	expression is a name expression with no disambiguation, then the left-hand side is a name left-hand side
	 * 	with the name from the name expression. If the expression is a name expression that disambiguates to a
	 * 	feature reference, then the left-hand side is a feature left-hand side for that feature reference. If the
	 * 	expression is a property access expression, then the left-hand side is a feature left-hand side for the
	 * 	feature reference of the property access expression. If the expression is a sequence access expression,
	 * 	then the left-hand side is a name left-hand side or feature left-hand side, as above, depending on whether
	 * 	the primary expression of the sequence access expression is a name expression or property access
	 * 	expression, and an index given by the index expression of the sequence access expression. Otherwise the
	 * 	left-hand side is empty.
	 */
	public void checkOutputNamedExpressionLeftHandSideDerivation() {
		
	}
	
}
