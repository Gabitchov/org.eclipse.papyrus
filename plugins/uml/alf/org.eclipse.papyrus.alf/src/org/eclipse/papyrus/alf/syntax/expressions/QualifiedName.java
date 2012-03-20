package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class QualifiedName extends SyntaxElement {

	// Synthesized Properties
	
	/*
	 * Whether this qualified name is ambiguous.
	 */
	public boolean isAmbiguous = false ;
	
	/*
	 * The sequence of individual name bindings in this qualified name.
	 */
	public List<NameBinding> nameBinding ;
	
	// Derived Properties
	
	/*
	 * The disambiguation into a feature reference of a syntactic element initially parsed as a qualified
	 * name.
	 */
	public FeatureReference disambiguation() {
		// LIMITATION: The parser implementation only supports :: (no .)
		// Therefore, a qualified name is never ambiguous
		return null ;
	}
	
	/*
	 * Indicates whether this qualified name has been disambiguated to a feature reference.
	 */
	public boolean isFeatureReference() {
		// LIMITATION: The parser implementation only supports :: (no .)
		// Therefore, a qualified name is never ambiguous
		return false ;
	}
	
	/*
	 * The complete path name for the qualified name, with individual name bindings separated by "::"
	 * punctuation.
	 */
	public String pathName() {
		String path = "" ;
		String doubleColon = "::" ;
		boolean first = true ;
		for (NameBinding n : this.nameBinding) {
			path += (first ? "" : doubleColon) + n.name ;
			if (first)
				first = false ;
			// TODO: Take into account template bindings
		}
		return path ;
	}
	
	/*
	 * The qualified name corresponding to the qualification part of this qualified name, if any.
	 */
	public QualifiedName qualification() {
		// TODO
		return null ;
	}
	
	/*
	 * The possible referents to which this qualified name may resolve. (Note that the UML rules for
	 * namespaces in general allow a namespace to contain elements of different kinds with the same
	 * name.) If the qualified name is for a template instantiation, then the referent is the equivalent bound
	 * element.
	 */
	public List<ElementReference> referent() {
		// TODO
		return new ArrayList<ElementReference>() ;
	}
	
	
	public QualifiedName templateName() {
		// TODO
		return null ;
	}
	
	/*
	 * The rightmost individual name binding in the qualified name, without the qualification.
	 */
	public NameBinding unqualifiedName() {
		// TODO
		return null ;
	}
	
	//Constraints
	
	/*
	 * If a qualified name is not ambiguous or it resolves to a namespace, then it is has no disambiguation.
	 * 	Otherwise, its disambiguation is a feature reference with a name given by the unqualified name of the
	 * 	qualified name and a target expression determined by the disambiguation of the qualification of the
	 * 	qualified name.
	 */
	public void checkQualifiedNameDisambiguationDerivation() {
		
	}
	
	/*
	 * A qualified name is a feature reference is its disambiguation is not empty.
	 */
	public void checkQualifiedNameIsFeatureReferenceDerivation() {
		
	}
	
	/*
	 * If a qualified name is a local name, then the reference must be within the same local scope as the
	 * 	definition of the named element.
	 */
	public void checkQualifiedNameLocalName() {
		
	}
	
	/*
	 * If a qualified name is an unqualified, non-local name, then it must be visible in the current scope of the
	 * 	use of the name.
	 */
	public void checkQualifiedNameNonLocalUnqualifiedName() {
		
	}
	
	/*
	 * The path name for a qualified name consists of the string representation of each of the name bindings,
	 * 	separated by "::" punctuation. The string representation of a name binding is its name followed by the
	 * 	representation of its template binding, if it has one. The string representation of a positional template
	 * 	binding consists of an ordered list of the path names of its argument qualified names separated by
	 * 	commas, all surrounded by the angle brackets "<" and ">". The string representation of a named
	 * 	template binding consists of an ordered list of its template parameter substitutions, each consisting of the
	 * 	formal parameter name followed by "=>" followed by the path name of the argument qualified name,
	 * 	separated by commas, all surrounded by the angle brackets "<" and ">".
	 */
	public void checkQualifiedNamePathNameDerivation() {
		
	}
	
	/*
	 * The qualification of a qualified name is a empty if the qualified name has only one name binding.
	 * 	Otherwise it is the qualified name consisting of all the name bindings of the original qualified name
	 * 	except for the last one. The qualification of a qualified name is considered ambiguous if the qualified
	 * 	name is ambiguous and has more than two name bindings.
	 */
	public void checkQualifiedNameQualificationDerivation() {
		
	}
	
	/*
	 * If a qualified name has a qualification, then its unqualified name must name an element of the
	 * 	namespace named by the qualification, where the first name in the qualification must name an element
	 * 	of the current scope.
	 */
	public void checkQualifiedNameQualifiedResolution() {
		
	}
	
	/*
	 * The referents of a qualified name are the elements to which the name may resolve in the current scope,
	 * 	according to the UML rules for namespaces and named elements.
	 */
	public void checkQualifiedNameReferentDerivation() {
		
	}
	
	/*
	 * If the unqualified name of a qualified name has a template binding, then the template name must resolve
	 * 	to a template. The template binding must have an argument name for each of the template parameters
	 * 	and each argument name must resolve to a classifier. If the template parameter has constraining
	 * 	classifiers, then the referent of the corresponding argument name must conform to all those constraining
	 * 	classifiers.
	 */
	public void checkQualifiedNameTemplateBinding() {
		
	}
	
	/*
	 * If the last name binding in a qualified name has a template binding, then the template name is a qualified
	 * 	name with the same template bindings as the original qualified name, but with the template binding
	 * 	removed on the last name binding.
	 */
	public void checkQualifiedNameTemplateNameDerivation() {
		
	}
	
	/*
	 * The unqualified name of a qualified name is the last name binding.
	 */
	public void checkQualifiedNameUnqualifiedNameDerivation() {
		
	}
	
	
}
