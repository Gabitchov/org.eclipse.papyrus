package org.eclipse.papyrus.alf.syntax.units;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;
import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;

public class ImportReference extends SyntaxElement {

	public QualifiedName referentName ;
	public UnitDefinition unit ;
	public String visibility ;

	//Derived Properties
	public ElementReference referent ;
	
	// Constraints
	
	/*
	 * The referent name of an import reference must resolve to a single element with public or empty
	 * 	visibility.
	 */
	public void checkImportReferenceReferent() {
		
	}
	
	/*
	 * The referent of an import reference is the element denoted by the referent name.
	 */
	public void checkImportReferenceReferentDerivation() {
		
	}
	
}
