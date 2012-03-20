package org.eclipse.papyrus.alf.syntax.units;

public class ActiveClassDefinition extends ClassDefinition {

	// Synthesized Properties
	public ActivityDefinition classifierBehavior ;

	// Helper Operations
	
	/*
	 * Returns true if the given unit definition matches this active class definition considered as a class
	 * 	definition and the subunit is for an active class definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
