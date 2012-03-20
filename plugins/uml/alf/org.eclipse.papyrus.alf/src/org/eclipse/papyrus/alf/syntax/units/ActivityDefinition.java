package org.eclipse.papyrus.alf.syntax.units;

import org.eclipse.papyrus.alf.syntax.statements.Block;

public class ActivityDefinition extends ClassifierDefinition {

	// Synthesized Properties
	public Block body ;

	// Constraints
	
	/*
	 * If an activity definition is primitive, then it must have a body that is empty.
	 */
	public void checkActivityDefinitionPrimitive() {
		
	}
	
	/*
	 * An activity definition may not have a specialization list.
	 */
	public void checkActivityDefinitionSpecialization() {
		
	}
	
	// Helper Operations
	
	/*
	 * In addition to the annotations allowed for classifiers in general, an activity definition allows @primitive
	 * 	annotations and any stereotype whose metaclass is consistent with Activity.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return super.annotationAllowed(annotation) && false ;
	}
	
	/*
	 * Returns true if the given unit definition matches this activity definition considered as a classifier
	 * 	definition and the subunit is for an activity definition. In addition, the subunit definition must have
	 * 	formal parameters that match each of the formal parameters of the stub definition, in order. Two formal
	 * 	parameters match if they have the same direction, name, multiplicity bounds, ordering, uniqueness and
	 * 	type reference.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
