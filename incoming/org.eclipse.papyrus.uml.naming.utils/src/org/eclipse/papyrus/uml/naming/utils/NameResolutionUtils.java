/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.naming.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.resource.UMLResource;

public class NameResolutionUtils {

	protected final String qualifiedNameSeparator = "::";
	
	/**
	 * From a given (potentially qualified) name and a scope, retrieves a list of NamedElement, filter by the filter metaclass (which can be null).
	 * If there are more than one element in the returned list, the name is ambiguous
	 * If the list is empty, the name does not correspond to any available named element in the context of the model resource set
	 * 
	 * @param name, the potentially/partially qualified name of the NamedElement to be resolved 
	 * @param scope, the namespace defining the scope for the name resolution
	 * @param filter, the potential "filter" metaclass (can be null)
	 * @return the list of NamedElement found by applying the resolution process
	 */
	public List<NamedElement> getNamedElements(String name, Element scope, EClass filter) {
		List<NamedElement> resolvedNamedElements = new ArrayList<NamedElement>() ;
		// In practice, a scope can only be a Namespace
		if (! (scope instanceof Namespace))
			return resolvedNamedElements ;
				
		// extracts name fragments for the given (potentially qualified) name
		List<String> nameFragments = computeNameFragments(name) ;
		// tries to resolve the name
		resolvedNamedElements.addAll(getNamedElements(nameFragments, (Namespace)scope, filter)) ;
		
		// If no named elements have been found, tries to restart the process on the enclosing namespace of the scope, if any
		if (resolvedNamedElements.isEmpty()) {
			Namespace enclosingNamespace = ((Namespace)scope).getNamespace() ;
			while (resolvedNamedElements.isEmpty() && enclosingNamespace != null) {
				resolvedNamedElements.addAll(getNamedElements(nameFragments, enclosingNamespace, filter)) ;
				enclosingNamespace = enclosingNamespace.getNamespace() ;
			}
		}
		
		// If no named elements have been found, tries to evaluate the name using the root context model has a root of the qualified name
		if (resolvedNamedElements.isEmpty()) {
			Namespace model = scope.getModel() ;
			if (model.getName().equals(nameFragments.get(0))) {
				if (nameFragments.size() == 1) {
					if (filter != null) {
						if (filter.isSuperTypeOf(model.eClass()))
							resolvedNamedElements.add(model) ;
					}
					else {
						resolvedNamedElements.add(model) ;
					}
				}
				else {
					List<String> remainingNameFragments = nameFragments.subList(1, nameFragments.size()) ;
					resolvedNamedElements.addAll(getNamedElements(remainingNameFragments, model, filter)) ;
				}
			}
		}
		
		// If no named elements have been found, tries to evaluate the name as a fully qualified name
		// This requires analysis of available UML resources in the context of scope resource set
		if (resolvedNamedElements.isEmpty()) {
			List<Resource> resources = scope.eResource().getResourceSet().getResources() ;
			for (Resource resource : resources) {
				if (resource != scope.eResource() && resource instanceof UMLResource) {
					UMLResource umlResource = (UMLResource)resource ;
					Model root = null ;
					for (Iterator<EObject> i = umlResource.getAllContents() ; i.hasNext() && root == null ; ) {
						EObject next = i.next() ;
						if (next instanceof Model)
							root = (Model)next ;
					}
					if (root != null) {
						if (root.getName().equals(nameFragments.get(0))) {
							if (nameFragments.size() == 1) {
								if (filter != null) {
									if (filter.isSuperTypeOf(root.eClass()))
										resolvedNamedElements.add(root) ;
								}
								else {
									resolvedNamedElements.add(root) ;
								}
							}
							else {
								List<String> remainingNameFragments = nameFragments.subList(1, nameFragments.size()) ;
								resolvedNamedElements.addAll(getNamedElements(remainingNameFragments, root, filter)) ;
							}
						}
					}
				}
			}
		}
		
		return resolvedNamedElements ;
	}
	
	/**
	 * From a given list of name fragments representing a (potentially qualified name), 
	 * retrieves a list of NamedElement.
	 * The basic principle of the algorithm is to try to match the first element of nameFragments with
	 * members of the scope.
	 * When a match is found, this method is called a recursively on a sublist of a nameFragments 
	 * (i.e., the first element is omitted) and on the matched member.
	 * The stop condition for recursivity is that the size of nameFragments is 1.
	 * 
	 * @param nameFragments, the potentially/partially qualified name of the NamedElement to be resolved 
	 * @param scope, the namespace defining the scope for the name resolution
	 * @param clazz, the potential "filter" metaclass (can be null)
	 * @return the list of NamedElement found by applying the resolution process
	*/
	protected List<NamedElement> getNamedElements(List<String> nameFragments, Namespace scope, EClass clazz) {
		List<NamedElement> resolvedNamedElements = new ArrayList<NamedElement>() ;
		// Tries to match the first name fragment with members of the scope
		for (NamedElement member : scope.getMembers()) {
			List<String> memberNames = scope.getNamesOfMember(member) ;
			String firstNameFragment = nameFragments.get(0) ;
			// iterates other names given to the current member in the context of this scope
			for (String memberName : memberNames) {
				if (memberName.equals(firstNameFragment)) {
					// the first fragment matches with this member
					if (nameFragments.size() == 1) { // Stop condition for recursivity
						if (clazz != null) {
							if (clazz.isSuperTypeOf(member.eClass()))
								resolvedNamedElements.add(member) ;
						}
						else {
							resolvedNamedElements.add(member) ;
						}
					}
					else {
						if (member instanceof Namespace) { // Recursive call on the sublist and the matching member
							List<String> remainingNameFragments = nameFragments.subList(1, nameFragments.size()) ;
							resolvedNamedElements.addAll(getNamedElements(remainingNameFragments, (Namespace)member, clazz)) ;
						}
					}
				}
			}
		}
		return resolvedNamedElements ;
	}

	/**
	 * Computes a List<String> containing the various "name fragments" of parameter "name".
	 * The string "name" is simply splitted according to qualifiedNameSeparator ("::").
	 * 
	 * @param name The name to be "fragmented"
	 * @return The list of name fragments
	 */
	protected List<String> computeNameFragments(String name) {
		String[] nameFragmentsArray = name.split(qualifiedNameSeparator) ;
		List<String> nameFragments = new ArrayList<String>() ;
		for (int i = 0 ; i < nameFragmentsArray.length ; i++) {
			nameFragments.add(nameFragmentsArray[i]) ;
		}
		return nameFragments ;
	}
	
	/**
	 * Computes the shortest qualified names for a named element, in the context of a scope.
	 * The shortest qualified names are the shortest name in terms of qualification depth which unambiguously
	 * resolve to the researched element.
	 * In the case where the returned list is empty, there is no unambiguous name that could be found, 
	 * including the fully qualified name of the element. This typically means that there are problems in the 
	 * context model in terms of organization of element imports and package imports and named element 
	 * definitions, or conflict in loaded UML resources.
	 * In the case where the list contains more than one name, all these names are all valid, all have the same
	 * qualification depth, and can be used indifferently. 
	 * 
	 * @param element, the named element for which we try to determine the shortest qualified name
	 * @param scope, the scope in which we try to determine the shortest qualified name for element
	 * @return the shortest qualified names for element
	 */
	public List<String> getShortestQualifiedNames(NamedElement element, Element scope) {
		List<String> shortestNames = new ArrayList<String>() ;
		// In practice, a scope can only be a Namespace
		if (! (scope instanceof Namespace)) {
			return shortestNames ;
		}
		// Tries to compute 
		shortestNames.addAll(getShortestQualifiedNamesOmittingFullyQualifiedName(element, (Namespace)scope)) ;
		
		// if no short name have been found, returns the fully qualified name, if it is itself unambiguous
		if(shortestNames.isEmpty()) {
			String fullyQualifiedNameOfElement = element.getQualifiedName() ;
			if (fullyQualifiedNameOfElement != null && ! (fullyQualifiedNameOfElement.length() == 0)) {
				shortestNames.add(fullyQualifiedNameOfElement) ;
				shortestNames.removeAll(findAmbiguousNames(shortestNames, element, (Namespace)scope)) ;
			}
		}
		return shortestNames ;
	}
	
	/**
	 * Computes the shortest qualified names for a named element in the context of a scope, omitting 
	 * fully qualified name of the named element (The fully qualified name is handled as a special case of
	 * getShortestQualifiedName, in the case where this method was not able to produce a non-ambiguous qualified
	 * name).
	 * The basic principle is the following (each step is applied if the previous one did not succeed. 
	 * "Evaluates" means assuring that computed names are not ambiguous):
	 * 1. if element and scope are the same, directly evaluates the name of the element.
	 * 2. if element is a member of scope, evaluates member names for this element,
	 * 3. Iterate over enclosing namespaces of scope, and if element is a member of an enclosing namespace,
	 * evaluate member names for element in the context of this enclosing namespace
	 * 4. Recursively call this method using the enclosing namespace of element as the reasearched named element,
	 * build partially qualified names from the obtained list, and evaluate the computed names
	 * 
	 * @param element, the named element for which we try to determine the shortest qualified name
	 * @param scope, the scope in which we try to determine the shortest qualified name for element
	 * @return the shortest qualified names for element (omitting the fully qualified name element) 
	 */
	protected List<String> getShortestQualifiedNamesOmittingFullyQualifiedName(NamedElement element, Namespace scope) {
		boolean continueResearch = true ;
		List<String> shortestNames = new ArrayList<String>() ;
		// if element and scope are the same, the shortest name is the name of the element
		if (element == scope) {
			shortestNames.add(element.getName()) ;
			shortestNames.removeAll(findAmbiguousNames(shortestNames, element, scope)) ;
			if (! shortestNames.isEmpty())
				continueResearch = false ;
		}
		// if element is part of the scope members, the shortest names are the names given to this member in the context of this scope
		if (continueResearch && scope.getMembers().contains(element)) {
			shortestNames.addAll(scope.getNamesOfMember(element)) ;
			shortestNames.removeAll(findAmbiguousNames(shortestNames, element, scope)) ;
			if (! shortestNames.isEmpty())
				continueResearch = false ;
		}
		if (continueResearch) {
			// tries to find element in the enclosing namespaces of scope
			Namespace enclosingNamespaceOfScope = scope.getNamespace() ;
			while (enclosingNamespaceOfScope != null && shortestNames.isEmpty()) {
				if (enclosingNamespaceOfScope.getMembers().contains(element)) {
					shortestNames.addAll(enclosingNamespaceOfScope.getNamesOfMember(element)) ;
					shortestNames.removeAll(findAmbiguousNames(shortestNames, element, scope)) ;
				}
				enclosingNamespaceOfScope = enclosingNamespaceOfScope.getNamespace() ;
			}
			if (shortestNames.isEmpty()) {
				// tries to find the shortest name for the enclosing namespace in the context of scope
				Namespace enclosingNamespaceOfElement = element.getNamespace() ;
				if (enclosingNamespaceOfElement != null) {
					List<String> shortestNamesForEnclosingNamespace = new ArrayList<String>() ;
					shortestNamesForEnclosingNamespace.addAll(getShortestQualifiedNames(enclosingNamespaceOfElement, scope)) ;
					// creates the list of shortest name from the list of shortest names for the enclosing namespace
					for (String shortestNameForEnclosing : shortestNamesForEnclosingNamespace) {
						List<String> memberNames = enclosingNamespaceOfElement.getNamesOfMember(element) ;
						for (String memberName : memberNames) {
							shortestNames.add(shortestNameForEnclosing + qualifiedNameSeparator + memberName) ;
						}
					}
					shortestNames.removeAll(findAmbiguousNames(shortestNames, element, scope)) ;
				}
			}
		}
		return shortestNames ;
	}
	
	/**
	 * From a list of names, select the names which do not unambiguously resolve to researchedElement,
	 * in the context of scope
	 * 
	 * @param names, the list of names to evaluate
	 * @param researchedElement, the element that must be resolved from the names
	 * @param scope, the scope in which evaluation happens
	 * @return the list of names which are ambiguous
	 */
	protected List<String> findAmbiguousNames(List<String> names, NamedElement researchedElement, Namespace scope) {
		List<String> ambiguousNames = new ArrayList<String>() ;
		for (String name : names) {
			if (isQualifiedNameAmbiguous(name, researchedElement, scope))
				ambiguousNames.add("" + name) ;
		}
		return ambiguousNames ;
	}
	
	
	/**
	 * Determines if a given name is ambiguous. From a given scope where evaluation of the name happens,
	 * a name is ambiguous if:
	 * - The given name resolves to multiple elements,
	 * - Or the name resolves to one element which is not the researched element.
	 * This method relies on getNamedElements(String, Element, EClass), using researchedElement.eClass() as a filter.
	 * 
	 * @param name
	 * @param researchedElement
	 * @param scope
	 * @return
	 */
	protected boolean isQualifiedNameAmbiguous(String name, NamedElement researchedElement, Namespace scope) {
		List<NamedElement> resolvedElements = getNamedElements(name, scope, researchedElement.eClass());
		if (resolvedElements.size() > 1)
			return true ;
		if (resolvedElements.get(0) != researchedElement)
			return true ;
		return false ;
	}
}
