package org.eclipse.papyrus.alf.syntax.units;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;

public class ReceptionDefinition extends Member {

	// Synthesized Properties
	public QualifiedName signalName ;
	
	// Derived Properties
	public ElementReference signal ;
	
	// Constraints
	
	/*
	 * A reception definition is a feature.
	 */
	public void checkReceptionDefinitionIsFeatureDerivation() {
		
	}
	
	/*
	 * The signal for a reception definition is the signal referent of the signal name for the reception definition.
	 */
	public void checkReceptionDefinitionSignalDerivation() {
		
	}
	
	/*
	 * The signal name for a reception definition must have a single referent that is a signal. This referent must
	 * 	not e a template.
	 */
	public void checkReceptionDefinitionSignalName() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * Returns true if the annotation is for a stereotype that has a metaclass consistent with Reception.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is either a ReceptionDefinition, a SignalReceptionDefinition or an
	 * 	imported member whose referent is a ReceptionDefinition, a SignalReceptionDefinition or a Reception.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
}
