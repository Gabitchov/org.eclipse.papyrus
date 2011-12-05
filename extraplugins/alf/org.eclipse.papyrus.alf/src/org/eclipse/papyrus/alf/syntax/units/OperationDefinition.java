package org.eclipse.papyrus.alf.syntax.units;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.statements.Block;
import org.eclipse.papyrus.alf.syntax.statements.QualifiedNameList;

public class OperationDefinition extends NamespaceDefinition{

	// Synthesized Properties
	public Block body ;
	public boolean isAbstract = false ;
	public QualifiedNameList redefinition ;
	
	// Derived Properties
	public boolean isConstructor ;
	public boolean isDestructor ;
	public List<ElementReference> redefinedOperations ;
	
	// Constraints
	
	/*
	 * If an operation definition is a constructor, any redefined operation for it must also be a constructor. The
	 * 	body of a constructor may contain an alternative constructor invocation for another constructor in the
	 * 	same class or super constructor invocations for constructors in immediate superclasses.
	 */
	public void checkOperationDefinitionConstructor() {
		
	}
	
	/*
	 * An operation definition cannot be both a constructor and a destructor.
	 */
	public void checkOperationDefinitionConstructorDestructor() {
		
	}
	
	/*
	 * If an operation definition is a destructor, any redefined operation for it must also be a destructor.
	 */
	public void checkOperationDefinitionDestructor() {
		
	}
	
	/*
	 * An operation definition is a constructor if it has a @Create annotation.
	 */
	public void checkOperationDefinitionIsConstructorDefinition() {
		
	}
	
	/*
	 * An operation definition is a destructor if it has a @Destroy annotation.
	 */
	public void checkOperationDefinitionIsDestructorDefinition() {
		
	}
	
	/*
	 * An operation definition is a feature.
	 */
	public void checkOperationDefinitionIsFeatureDerivation() {
		
	}
	
	/*
	 * The namespace for an operation definition must be a class definition. If the operation definition is
	 * 	abstract, then the class definition must be abstract.
	 */
	public void checkOperationDefinitionNamespace() {
		
	}
	
	/*
	 * The redefined operations of an operation definition must have formal parameters that match each of the
	 * 	formal parameters of this operation definition, in order. Two formal parameters match if they have the
	 * 	same direction, name, multiplicity bounds, ordering, uniqueness and type reference.
	 */
	public void checkOperationDefinitionRedefinedOperations() {
		
	}
	
	/*
	 * If an operation definition has a redefinition list, its redefined operations are the referent operations of the
	 * 	names in the redefinition list for the operation definition. Otherwise, the redefined operations are any
	 * 	operations that would otherwise be indistinguishable from the operation being defined in this operation
	 * 	definition.
	 */
	public void checkOperationDefinitionRedefinedOperationsDerivation() {
		
	}
	
	/*
	 * Each name in the redefinition list of an operation definition must have a signal referent that is an
	 * 	operation. This operation must be a non-private operation that is a member of a specialization referent of
	 * 	the class definition of the operation definition.
	 */
	public void checkOperationDefinitionRedefinition() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * Returns true if the annotation is for a stereotype that has a metaclass consistent with Operation.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is either an OperationDefinition or an imported member whose referent
	 * 	is an OperationDefinition or an Operation, and the formal parameters of this operation definition match,
	 * 	in order, the parameters of the other operation definition or operation. In this context, matching means
	 * 	the same name and type (per UML Superstructure, Subclause 7.3.5).
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * The namespace definition associated with the given unit definition must be an activity definition with no
	 * 	template parameters. In addition, the subunit definition must have formal parameters that match each of
	 * 	the formal parameters of the stub definition, in order. Two formal parameters match if they have the
	 * 	same direction, name, multiplicity bounds, ordering, uniqueness and type reference.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
