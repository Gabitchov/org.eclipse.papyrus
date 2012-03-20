package org.eclipse.papyrus.alf.syntax.units;

public class DataTypeDefinition extends ClassifierDefinition {

	// Constraints
	
	/*
	 * If a data type is primitive, then it may not have any owned members.
	 */
	public void checkDataTypeDefinitionPrimitive() {
		
	}
	
	/*
	 * The specialization referents of a data type definition must all be data types.
	 */
	public void checkDataTypeDefinitionSpecializationReferent() {
		
	}
	
	// Helper Operations
	
	/*
	 * In addition to the annotations allowed for classifiers in general, a data type definition allows @primitive
	 * 	annotations plus any stereotype whose metaclass is consistent with DataType.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return super.annotationAllowed(annotation) && false ;
	}
	
	/*
	 * Return true if the given member is either a DataTypeDefinition or an imported member whose referent
	 * 	is a DataTypeDefinition or a DataType.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns true if the given unit definition matches this data type definition considered as a classifier
	 * 	definition and the subunit is for a data type definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
	
}
