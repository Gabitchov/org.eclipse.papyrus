package org.eclipse.papyrus.alf.syntax.units;

import java.util.List;

import org.eclipse.uml2.uml.Profile;

public class PackageDefinition extends NamespaceDefinition {

	// Derived Properties
	public List<Profile> appliedProfile ;
	
	// Constraints
	
	/*
	 * The applied profiles of a package definition are the profiles listed in any @apply annotations on the
	 * 	package.
	 */
	public void checkPackageDefinitionAppliedProfileDerivation() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * In addition to the annotations allowed on any namespace definition, a package definition allows @apply
	 * 	annotations plus any stereotype whose metaclass is consistent with Package.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is either a PackageDefinition or an imported member whose referent is
	 * 	a PackageDefinition or a Package.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns true of the namespace definition associated with the given unit definition is a package
	 * 	definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
