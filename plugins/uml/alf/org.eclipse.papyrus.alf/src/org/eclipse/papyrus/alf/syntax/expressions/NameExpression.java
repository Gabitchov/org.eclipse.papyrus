package org.eclipse.papyrus.alf.syntax.expressions;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.ElementReference;

public class NameExpression extends Expression {

	// Synthesized Properties
	public QualifiedName name ;
	
	// Derived Properties
	public AssignedSource assignment ;
	public ElementReference enumerationLiteral ;
	public PropertyAccessExpression propertyAccess ;
	
	// Constraints
	
	/*
	 * If the name in a name expression is a local or parameter name, then its assignment is its assigned source
	 * 	before the expression.
	 */
	public void checkNameExpressionAssignmentDerivation() {
		
	}
	
	/*
	 * If the name in a name expression resolves to an enumeration literal name, then that is the enumeration
	 * 	literal for the expression.
	 */
	public void checkNameExpressionEnumerationLiteralDerivation() {
		
	}
	
	/*
	 * The multiplicity lower bound of a name expression is determined by its name.
	 */
	public void checkNameExpressionLowerDerivation() {
		
	}
	
	/*
	 * If the name in a name expression disambiguates to a feature reference, then the equivalent property
	 * 	access expression has the disambiguation of the name as its feature. The assignments before the property
	 * 	access expression are the same as those before the name expression.
	 */
	public void checkNameExpressionPropertyAccessDerivation() {
		
	}
	
	/*
	 * If the name referenced by this expression is not a disambiguated feature reference or a local or
	 * 	parameter name, then it must resolve to exactly one enumeration literal.
	 */
	public void checkNameExpressionResolution() {
		
	}
	
	/*
	 * The type of a name expression is determined by its name. If the name is a local name or parameter with
	 * 	an assignment, then the type of the name expression is the type of that assignment. If the name is an
	 * 	enumeration literal, then the type of the name expression is the corresponding enumeration. If the name
	 * 	disambiguates to a feature reference, then the type of the name expression is the type of the equivalent
	 * 	property access expression.
	 */
	public void checkNameExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a name expression is determined by its name.
	 */
	public void checkNameExpressionUpperDerivation() {
		
	}
	
}
