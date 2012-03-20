package org.eclipse.papyrus.alf.syntax.units;

public class EnumerationDefinition extends ClassifierDefinition {

	// Constraints
	
	/*
	 * The specialization referents of a class definition must all be classes. A class definition may not have any
	 * 	referents that are active classes unless this is an active class definition.
	 */
	public void checkClassDefinitionSpecializationReferent() {
		
	}
	
	// Helper Operations
	
	/*
	 * In addition to the annotations allowed for classifiers in general, an enumeration definition allows an
	 * 	annotation for any stereotype whose metaclass is consistent with Enumeration.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return super.annotationAllowed(annotation) && false ;
	}
	
	/*
	 * Return true if the given member is either an EnumerationDefinition or an imported member whose
	 * 	referent is an EnumerationDefinition or an Enumeration.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns true if the given unit definition matches this enumeration definition considered as a classifier
	 * 	definition and the subunit is for an enumeration definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
	
}
