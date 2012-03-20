package org.eclipse.papyrus.alf.syntax.expressions;

public class ClassExtentExpression extends Expression {
	
	//Synthesized Properties
	public QualifiedName className ; 
	
	//Constraints
	/*
	 * The given type name must resolve to a non-template class.
	 */
	public void checkClassExtentExpressionExtentType() {
		
	}
	
	/*
	 * The multiplicity lower bound of a class extent expression is 0.
	 */
	public void checkClassExtentExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a class extent expression is the given class.
	 */
	public void checkClassExtentExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a class expression is *.
	 */
	public void checkClassExtentExpressionUpperDerivation() {
		
	}
}
