package org.eclipse.papyrus.alf.syntax.units;

import java.util.List;

public class NamespaceDefinition extends Member {

	// Synthesized Properties
	public List<Member> ownedMember ;
	public UnitDefinition unit ;
	
	// Derived Properties
	public List<Member> member ;
	
	// Constraints
	
	/*
	 * The members of a namespace definition include references to all owned members. Also, if the
	 * 	namespace definition has a unit with imports, then the members include imported members with
	 * 	referents to all imported elements. The imported elements and their visibility are determined as given in
	 * 	the UML Superstructure. The name of an imported member is the name of the imported element or its
	 * 	alias, if one has been given for it. Elements that would be indistinguishable from each other or from an
	 * 	owned member (as determined by the Member::isDistinguishableFrom operation) are not imported.
	 */
	public void checkNamespaceDefinitionMemberDerivation() {
		
	}
	
	/*
	 * The members of a namespace must be distinguishable as determined by the
	 * 	Member::isDistinguishableFrom operation.
	 */
	public void checkNamespaceDefinitionMemberDistinguishaibility() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * Returns true if the annotation is @external.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
}
