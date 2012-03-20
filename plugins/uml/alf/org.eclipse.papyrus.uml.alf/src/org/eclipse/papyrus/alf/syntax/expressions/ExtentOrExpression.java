package org.eclipse.papyrus.alf.syntax.expressions;

public class ExtentOrExpression {

	// Synthesized Properties
	public QualifiedName name ;
	public Expression nonNameExpression ;


	//Derived Properties
	public Expression expression ;
	
	// Constraints
	
	/*
	 * The effective expression for the target is the parsed primary expression, if the target is not a qualified
	name, a name expression, if the target is a qualified name other than a class name, or a class extent
	expression, if the target is the qualified name of a class.
	 */
	public void checkExtentOrExpressionExpressionDerivation() {
		
	}
	
}
