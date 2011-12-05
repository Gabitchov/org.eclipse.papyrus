package org.eclipse.papyrus.alf.syntax.expressions;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class FeatureReference extends SyntaxElement {

	// Synthesized Properties
	
	/*
	 * The target expression.
	 */
	public Expression  expression ;
	
	/*
	 * The name of the feature
	 */
	public NameBinding nameBinding ;

	//Derived Properties
	public ElementReference referent ;

	// Constraints
	
	/*
	 * The features referenced by a feature reference include the features of the type of the target expression
	 * 	and the association ends of any binary associations whose opposite ends are typed by the type of the
	 * 	target expression.
	 */
	public void checkFeatureReferenceReferentDerivation() {
		
	}
	
	/*
	 * The target expression of the feature reference may not be untyped, nor may it have a primitive or
	 * 	enumeration type.
	 */
	public void checkFeatureReferenceTargetType() {
		
	}
	
}
