package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;

public class InstanceCreationExpression extends InvocationExpression {

	// Synthesized Properties
	public QualifiedName constructor ;

	// Derived Properties
	public boolean isConstructorless ;
	public boolean isObjectCreation ;

	// Constraints
	
	/*
	 * The constructor name must resolve to a constructor operation (that is compatible with the tuple
	 * 	argument expressions), a class or a data type, but not both a class and a data type.
	 */
	public void checkInstanceCreationExpressionConstructor() {
		
	}
	
	/*
	 * If an instance creation expression is a data value creation (not an object creation), then the tuple
	 * 	argument expressions are matched with the attributes of the named type.
	 */
	public void checkInstanceCreationExpressionDataTypeCompatibility() {
		
	}
	
	/*
	 * There is no feature for an instance creation expression.
	 */
	public void checkInstanceCreationExpressionFeatureDerivation() {
		
	}
	
	/*
	 * An instance creation expression is constructorless if its referent is a class.
	 */
	public void checkInstanceCreationExpressionIsConstructorlessDerivation() {
		
	}
	
	/*
	 * An instance creation expression is an object creation if its referent is not a data type.
	 */
	public void checkInstanceCreationExpressionIsObjectCreationDerivation() {
		
	}
	
	/*
	 * The referent of an instance creation expression is the constructor operation, class or data type to which
	 * the constructor name resolves.
	 */
	public void checkInstanceCreationExpressionReferentDerivation() {
		
	}
	
	/*
	 * If the expression is constructorless, then its tuple must be empty.
	 */
	public void checkInstanceCreationExpressionTuple() {
		
	}
	
	// Helper Operations
	
	/*
	 * Returns the parameters of a constructor operation or the attributes of a data type, or an empty set for a
	 * constructorless instance creation.
	 */
	public List<ElementReference> parameterElements ( ) {
		return new ArrayList<ElementReference>() ;
	}

}
