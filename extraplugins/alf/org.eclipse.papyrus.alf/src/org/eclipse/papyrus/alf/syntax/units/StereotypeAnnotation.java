package org.eclipse.papyrus.alf.syntax.units;

import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;
import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;
import org.eclipse.papyrus.alf.syntax.statements.QualifiedNameList;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeAnnotation extends SyntaxElement {

	// Synthesized Properties
	public QualifiedNameList names ;
	public QualifiedName stereotypeName ; 
	public TaggedValueList taggedValues ;
	
	// Derived Properties
	public Stereotype stereotype ;
	
	// Constraints
	
	/*
	 * If the stereotype name of a stereotype annotation is "apply", then it must have a name list and all of the
	 * 	names in the list must resolve to profiles.
	 */
	public void checkStereotypeAnnotationApply() {
		
	}
	
	/*
	 * If the stereotype name of a stereotype annotation is "external", then it may optionally have a single
	 * 	tagged value with the name "file" and no operator.
	 */
	public void checkStereotypeAnnotationExternal() {
		
	}
	
	/*
	 * If a stereotype annotation has a stereotype and a list of names, then all the names in the list must resolve
	 * 	to visible model elements and the stereotype must have a single attribute with a (metaclass) type and
	 * 	multiplicity that are consistent with the types and number of the elements denoted by the given names.
	 */
	public void checkStereotypeAnnotationNames() {
		
	}

	/*
	 * If the stereotype name of a stereotype annotation is "primitive", then it may not have tagged values or
	 * 	names.
	 */
	public void checkStereotypeAnnotationPrimitive() {
		
	}
	
	/*
	 * Unless the stereotype name is "apply", "primitive" or "external" then the stereotype for a stereotype
	 * 	annotation is the stereotype denoted by the stereotype name.
	 */
	public void checkStereotypeAnnotationStereotypeDerivation() {
		
	}
	
	/*
	 * The stereotype name of a stereotype annotation must either be one of "apply", "primitive" or "external",
	 * 	or it must denote a single stereotype from a profile applied to an enclosing package. The stereotype
	 * 	name does not need to be qualified if there is only one applied profile with a stereotype of that name or
	 * 	if the there is a standard UML profile with the name.
	 */
	public void checkStereotypeAnnotationStereotypeName() {
		
	}
	
	/*
	 * If a stereotype annotation has a stereotype and tagged values, then the each tagged value must have the
	 * 	name of an attribute of the stereotype and a value that is legally interpretable for the type of that
	 * 	attribute.
	 */
	public void checkStereotypeAnnotationTaggedValues() {
		
	}
	
}
