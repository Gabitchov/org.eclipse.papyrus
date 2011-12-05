package org.eclipse.papyrus.alf.syntax.units;

public class FormalParameter extends TypedElementDefinition {

	// Synthesized Properties
	public String direction ;

	// Helper Operations
	
	/*
	 * Returns true if the annotation is for a stereotype that has a metaclass consistent with Parameter.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is a FormalParameter.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
}
