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
 *  Arnaud Cuccuru (CEA LIST) - Initial API and implementation
 *  Vincent Lorenzo   (CEA LIST)
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.utils;

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


	private NameResolutionUtils() {
		// to prevent instanciation
	}

	/**
	 * From a given (potentially qualified) name and a scope, retrieves a list of NamedElement, filter by the filter metaclass (which can be null).
	 * If there are more than one element in the returned list, the name is ambiguous
	 * If the list is empty, the name does not correspond to any available named element in the context of the model resource set
	 * 
	 * @param name
	 *        , the potentially/partially qualified name of the NamedElement to be resolved
	 * @param scope
	 *        , the namespace defining the scope for the name resolution
	 * @param filter
	 *        , the potential "filter" metaclass (can be null)
	 * @return the list of NamedElement found by applying the resolution process
	 */
	public static final List<NamedElement> getNamedElements(final String name, final Element scope, final EClass filter) {
		final List<NamedElement> resolvedNamedElements = new ArrayList<NamedElement>();
		// In practice, a scope can only be a Namespace
		if(!(scope instanceof Namespace)) {
			return resolvedNamedElements;
		}
		return NameResolutionUtils.getNamedElements(name, (Namespace)scope, filter);
	}

	/**
	 * From a given (potentially qualified) name and a scope, retrieves a list of NamedElement, filter by the filter metaclass (which can be null).
	 * If there are more than one element in the returned list, the name is ambiguous
	 * If the list is empty, the name does not correspond to any available named element in the context of the model resource set
	 * 
	 * @param name
	 *        , the potentially/partially qualified name of the NamedElement to be resolved
	 * @param scope
	 *        , the namespace defining the scope for the name resolution
	 * @param filter
	 *        , the potential "filter" metaclass (can be null)
	 * @return the list of NamedElement found by applying the resolution process
	 */
	public static final List<NamedElement> getNamedElements(final String name, final Namespace scope, final EClass filter) {
		final List<NamedElement> resolvedNamedElements = new ArrayList<NamedElement>();

		// extracts name fragments for the given (potentially qualified) name
		final List<String> nameFragments = NameResolutionUtils.computeNameFragments(name);
		// tries to resolve the name
		resolvedNamedElements.addAll(NameResolutionUtils.getNamedElements(nameFragments, scope, filter));

		// If no named elements have been found, tries to restart the process on the enclosing namespace of the scope, if any
		if(resolvedNamedElements.isEmpty()) {
			Namespace enclosingNamespace = scope.getNamespace();
			while(resolvedNamedElements.isEmpty() && (enclosingNamespace != null)) {
				resolvedNamedElements.addAll(NameResolutionUtils.getNamedElements(nameFragments, enclosingNamespace, filter));
				enclosingNamespace = enclosingNamespace.getNamespace();
			}
		}

		// If no named elements have been found, tries to evaluate the name using the root context model has a root of the qualified name
		if(resolvedNamedElements.isEmpty()) {
			Namespace model = scope.getModel();
			if(model==null){
				model = scope;
			}
			if(model.getName().equals(nameFragments.get(0))) {
				if(nameFragments.size() == 1) {
					if(filter != null) {
						if(filter.isSuperTypeOf(model.eClass())) {
							resolvedNamedElements.add(model);
						}
					} else {
						resolvedNamedElements.add(model);
					}
				} else {
					final List<String> remainingNameFragments = nameFragments.subList(1, nameFragments.size());
					resolvedNamedElements.addAll(NameResolutionUtils.getNamedElements(remainingNameFragments, model, filter));
				}
			}
		}

		// If no named elements have been found, tries to evaluate the name as a fully qualified name
		// This requires analysis of available UML resources in the context of scope resource set
		if(resolvedNamedElements.isEmpty()) {
			final List<Resource> resources = scope.eResource().getResourceSet().getResources();
			for(final Resource resource : resources) {
				if((resource != scope.eResource()) && (resource instanceof UMLResource)) {
					final UMLResource umlResource = (UMLResource)resource;
					Model root = null;
					for(final Iterator<EObject> i = umlResource.getAllContents(); i.hasNext() && (root == null);) {
						final EObject next = i.next();
						if(next instanceof Model) {
							root = (Model)next;
						}
					}
					if(root != null) {
						if(root.getName().equals(nameFragments.get(0))) {
							if(nameFragments.size() == 1) {
								if(filter != null) {
									if(filter.isSuperTypeOf(root.eClass())) {
										resolvedNamedElements.add(root);
									}
								} else {
									resolvedNamedElements.add(root);
								}
							} else {
								final List<String> remainingNameFragments = nameFragments.subList(1, nameFragments.size());
								resolvedNamedElements.addAll(NameResolutionUtils.getNamedElements(remainingNameFragments, root, filter));
							}
						}
					}
				}
			}
		}

		return resolvedNamedElements;
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
	 * @param nameFragments
	 *        , the potentially/partially qualified name of the NamedElement to be resolved
	 * @param scope
	 *        , the namespace defining the scope for the name resolution
	 * @param clazz
	 *        , the potential "filter" metaclass (can be null)
	 * @return the list of NamedElement found by applying the resolution process
	 */
	private static final List<NamedElement> getNamedElements(final List<String> nameFragments, final Namespace scope, final EClass clazz) {
		final List<NamedElement> resolvedNamedElements = new ArrayList<NamedElement>();
		// Tries to match the first name fragment with members of the scope
		for(final NamedElement member : scope.getMembers()) {
			final List<String> memberNames = scope.getNamesOfMember(member);
			final String firstNameFragment = nameFragments.get(0);
			// iterates other names given to the current member in the context of this scope
			for(final String memberName : memberNames) {
				if(memberName.equals(firstNameFragment)) {
					// the first fragment matches with this member
					if(nameFragments.size() == 1) { // Stop condition for recursivity
						if(clazz != null) {
							if(clazz.isSuperTypeOf(member.eClass())) {
								resolvedNamedElements.add(member);
							}
						} else {
							resolvedNamedElements.add(member);
						}
					} else {
						if(member instanceof Namespace) { // Recursive call on the sublist and the matching member
							final List<String> remainingNameFragments = nameFragments.subList(1, nameFragments.size());
							resolvedNamedElements.addAll(NameResolutionUtils.getNamedElements(remainingNameFragments, (Namespace)member, clazz));
						}
					}
				}
			}
		}
		return resolvedNamedElements;
	}

	/**
	 * Computes a List<String> containing the various "name fragments" of parameter "name".
	 * The string "name" is simply splitted according to qualifiedNameSeparator ("::").
	 * 
	 * @param name
	 *        The name to be "fragmented"
	 * @return The list of name fragments
	 */
	private static final List<String> computeNameFragments(final String name) {
		final String[] nameFragmentsArray = name.split(NamedElementUtil.QUALIFIED_NAME_SEPARATOR);
		final List<String> nameFragments = new ArrayList<String>();
		for(final String element : nameFragmentsArray) {
			nameFragments.add(element);
		}
		return nameFragments;
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
	 * @param element
	 *        , the named element for which we try to determine the shortest qualified name
	 * @param scope
	 *        , the scope in which we try to determine the shortest qualified name for element
	 * @return the shortest qualified names for element
	 */
	public static final List<String> getShortestQualifiedNames(final NamedElement element, final Element scope) {
		final List<String> shortestNames = new ArrayList<String>();
		// In practice, a scope can only be a Namespace
		if(!(scope instanceof Namespace)) {
			return shortestNames;
		}
		return NameResolutionUtils.getShortestQualifiedNames(element, (Namespace)scope);
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
	 * @param element
	 *        , the named element for which we try to determine the shortest qualified name
	 * @param scope
	 *        , the scope in which we try to determine the shortest qualified name for element
	 * @return the shortest qualified names for element
	 */
	public static final List<String> getShortestQualifiedNames(final NamedElement element, final Namespace scope) {
		final List<String> shortestNames = new ArrayList<String>();

		// Tries to compute 
		shortestNames.addAll(NameResolutionUtils.getShortestQualifiedNamesOmittingFullyQualifiedName(element, scope));

		// if no short name have been found, returns the fully qualified name, if it is itself unambiguous
		if(shortestNames.isEmpty()) {
			final String fullyQualifiedNameOfElement = element.getQualifiedName();
			if((fullyQualifiedNameOfElement != null) && !(fullyQualifiedNameOfElement.length() == 0)) {
				shortestNames.add(fullyQualifiedNameOfElement);
				shortestNames.removeAll(NameResolutionUtils.findAmbiguousNames(shortestNames, element, scope));
			}
		}
		return shortestNames;
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
	 * @param element
	 *        , the named element for which we try to determine the shortest qualified name
	 * @param scope
	 *        , the scope in which we try to determine the shortest qualified name for element
	 * @return the shortest qualified names for element (omitting the fully qualified name element)
	 */
	private static final List<String> getShortestQualifiedNamesOmittingFullyQualifiedName(final NamedElement element, final Namespace scope) {
		boolean continueResearch = true;
		final List<String> shortestNames = new ArrayList<String>();
		// if element and scope are the same, the shortest name is the name of the element
		if(element == scope) {
			shortestNames.add(element.getName());
			shortestNames.removeAll(NameResolutionUtils.findAmbiguousNames(shortestNames, element, scope));
			if(!shortestNames.isEmpty()) {
				continueResearch = false;
			}
		}
		// if element is part of the scope members, the shortest names are the names given to this member in the context of this scope
		if(continueResearch && scope.getMembers().contains(element)) {
			shortestNames.addAll(scope.getNamesOfMember(element));
			shortestNames.removeAll(NameResolutionUtils.findAmbiguousNames(shortestNames, element, scope));
			if(!shortestNames.isEmpty()) {
				continueResearch = false;
			}
		}
		if(continueResearch) {
			// tries to find element in the enclosing namespaces of scope
			Namespace enclosingNamespaceOfScope = scope.getNamespace();
			while((enclosingNamespaceOfScope != null) && shortestNames.isEmpty()) {
				if(enclosingNamespaceOfScope.getMembers().contains(element)) {
					shortestNames.addAll(enclosingNamespaceOfScope.getNamesOfMember(element));
					shortestNames.removeAll(NameResolutionUtils.findAmbiguousNames(shortestNames, element, scope));
				}
				enclosingNamespaceOfScope = enclosingNamespaceOfScope.getNamespace();
			}
			if(shortestNames.isEmpty()) {
				// tries to find the shortest name for the enclosing namespace in the context of scope
				final Namespace enclosingNamespaceOfElement = element.getNamespace();
				if(enclosingNamespaceOfElement != null) {
					final List<String> shortestNamesForEnclosingNamespace = new ArrayList<String>();
					shortestNamesForEnclosingNamespace.addAll(NameResolutionUtils.getShortestQualifiedNames(enclosingNamespaceOfElement, scope));
					// creates the list of shortest name from the list of shortest names for the enclosing namespace
					for(final String shortestNameForEnclosing : shortestNamesForEnclosingNamespace) {
						final List<String> memberNames = enclosingNamespaceOfElement.getNamesOfMember(element);
						for(final String memberName : memberNames) {
							shortestNames.add(shortestNameForEnclosing + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + memberName);
						}
					}
					shortestNames.removeAll(NameResolutionUtils.findAmbiguousNames(shortestNames, element, scope));
				}
			}
		}
		return shortestNames;
	}

	/**
	 * From a list of names, select the names which do not unambiguously resolve to researchedElement,
	 * in the context of scope
	 * 
	 * @param names
	 *        , the list of names to evaluate
	 * @param researchedElement
	 *        , the element that must be resolved from the names
	 * @param scope
	 *        , the scope in which evaluation happens
	 * @return the list of names which are ambiguous
	 */
	private static final List<String> findAmbiguousNames(final List<String> names, final NamedElement researchedElement, final Namespace scope) {
		final List<String> ambiguousNames = new ArrayList<String>();
		for(final String name : names) {
			if(NameResolutionUtils.isQualifiedNameAmbiguous(name, researchedElement, scope)) {
				ambiguousNames.add("" + name);
			}
		}
		return ambiguousNames;
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
	private static final boolean isQualifiedNameAmbiguous(final String name, final NamedElement researchedElement, final Namespace scope) {
		final List<NamedElement> resolvedElements = NameResolutionUtils.getNamedElements(name, scope, researchedElement.eClass());
		if(resolvedElements.size() > 1) {
			return true;
		}
		if(resolvedElements.get(0) != researchedElement) {
			return true;
		}
		return false;
	}
}
