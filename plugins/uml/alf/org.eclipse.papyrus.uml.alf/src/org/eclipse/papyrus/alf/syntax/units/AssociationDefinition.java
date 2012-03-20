package org.eclipse.papyrus.alf.syntax.units;

public class AssociationDefinition extends ClassifierDefinition {

	// Constraints
	
	/*
	 * The specialization referents of an association definition must all be associations.
	 */
	public void checkAssociationDefinitionSpecializationReferent() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * In addition to the annotations allowed for classifiers in general, an association definition allows an
	 * 	annotation for any stereotype whose metaclass is consistent with Association.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return super.annotationAllowed(annotation) && false ;
	}
	
	/*
	 * Return true if the given member is either an AssociationDefinition or an imported member whose
	 * 	referent is an AssociationDefinition or an Association.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns true if the given unit definition matches this association definition considered as a classifier
	 * 	definition and the subunit is for an association definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
