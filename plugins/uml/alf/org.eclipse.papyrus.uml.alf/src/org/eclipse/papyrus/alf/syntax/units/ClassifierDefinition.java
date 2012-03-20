package org.eclipse.papyrus.alf.syntax.units;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;

public class ClassifierDefinition extends NamespaceDefinition {

	// Synthesized Properties
	public boolean isAbstract = false ;
	public QualifiedName specialization ;
	
	// Derived Properties
	public List<ElementReference> specializationReferent ;
	
	// Constraints
	
	/*
	 * The members of a classifier definition include non-private members inherited from the classifiers it
	 * 	specializes. The visibility of inherited members is as specified in the UML Superstructure, Subclause
	 * 	7.3.8.
	 */
	public void checkClassifierDefinitionInheritedMembers() {
		
	}

	/*
	 * Each name listed in the specialization list for a classifier definition must have a single classifier referent.
	 * 	None of these referents may be templates.
	 */
	public void checkClassifierDefinitionSpecialization() {
		
	}
	
	/*
	 * The specialization referents of a classifier definition are the classifiers denoted by the names in the
	 * 	specialization list for the classifier definition.
	 */
	public void checkClassifierDefinitionSpecializationReferentDerivation() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * The namespace definition associated with the given unit definition must be a classifier definition. The
	 * 	subunit classifier definition may be abstract if and only if the subunit classifier definition is abstract. The
	 * 	subunit classifier definition must have the same specialization referents as the stub classifier definition.
	 * 	(Note that it is the referents that must match, not the exact names or the ordering of those names in the
	 * 	specialization list.) The subunit classifier definition must also have a matching classifier template
	 * 	parameter for each classifier template parameter of the stub classifier definition. Two template
	 * 	parameters match if they have same names and the same specialization referents.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
