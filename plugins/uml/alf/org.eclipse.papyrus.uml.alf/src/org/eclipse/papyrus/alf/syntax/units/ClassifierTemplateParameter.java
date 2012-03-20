package org.eclipse.papyrus.alf.syntax.units;

public class ClassifierTemplateParameter extends ClassifierDefinition {

	// Helper Operations
	
	/*
	 * Annotations are not allowed on classifier template parameters.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is a classifier template parameter.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns false. (Classifier template parameters cannot be stubs.)
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
	
}
