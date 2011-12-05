package org.eclipse.papyrus.alf.syntax.units;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.DocumentedElement;

public class Member extends DocumentedElement {

	// Synthesized Properties
	public List<StereotypeAnnotation> annotation ;
	public boolean isStub = false ;
	public String name ;
	public NamespaceDefinition namespace ;
	public String visibility ;
	
	// Derived Properties
	public boolean isExternal ;
	public boolean isFeature = false ;
	public boolean isPrimitive ;
	public UnitDefinition subunit ;
	
	// Constraints
	
	/*
	 * All stereotype annotations for a member must be allowed, as determined using the stereotypeAllowed
	 * 	operation.
	 */
	public void checkMemberAnnotations() {
		
	}
	
	/*
	 * If a member is external then it must be a stub. 
	 */
	public void checkMemberExternal() {
		
	}
	
	/*
	 * A member is external if it has an @external derivation.
	 */
	public void checkMemberIsExternalDerivation() {
		
	}
	
	/*
	 * A member is primitive if it has a @primitive annotation.
	 */
	public void checkMemberIsPrimitiveDerivation() {
		
	}
	
	/*
	 * If a member is primitive, then it may not be a stub and it may not have any owned members that are
	 * 	template parameters.
	 */
	public void checkMemberPrimitive() {
		
	}
	
	/*
	 * If a member is a stub and is not external, then there must be a single subunit with the same qualified
	 * 	name as the stub that matches the stub, as determined by the matchForStub operation.
	 */
	public void checkMemberStub() {
		
	}
	
	/*
	 * If a member is a stub, then the it must not have any stereotype annotations that are the same as its
	 * 	subunit. Two stereotype annotations are the same if they are for the same stereotype.
	 */
	public void checkMemberStubStereotypes() {
		
	}
	
	/*
	 * If the member is a stub and is not external, then its corresponding subunit is a unit definition with the
	 * 	same fully qualified name as the stub.
	 */
	public void checkMemberSubunitDerivation() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * Returns true of the given stereotype annotation is allowed for this kind of element.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Returns true if this member is distinguishable from the given member. Two members are distinguishable
	 * 	if their names are different or the they are of different kinds (as determined by the isSameKindAs
	 * 	operation). However, in any case that the UML Superstructure considers two names to be
	 * 	distinguishable if they are different, an Alf implementation may instead impose the stronger requirement
	 * 	that the names not be conflicting.
	 */
	public boolean isDistinguishableFrom(Member member) {
		return false ;
	}
	
	/*
	 * Returns true if this member is of the same kind as the given member.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns true of the given unit definition is a legal match for this member as a stub. By default, always
	 * 	returns false.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
