/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY  (CEA LIST) Yann.Tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.uml2.uml.Namespace;

/**
 * 
 * 
 * 
 * This class represents any UML element
 */
public class NamedElement extends Element {

	/**
	 * 
	 */
	protected final String QUALIFIED_NAME_SEPARATOR = "::";

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.NamedElement uml2NamedElement;

	/**
	 * 
	 * 
	 * @param namedElement
	 */
	public NamedElement(org.eclipse.uml2.uml.NamedElement namedElement) {
		super(namedElement);
		uml2NamedElement = namedElement;
	}

	/**
	 * 
	 */
	public NamedElement() {
		uml2NamedElement = null;
	}

	/**
	 * 
	 * 
	 * @return
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java.internal.UML2JavaTransform)"
	 */
	public String getName() {
		return uml2NamedElement.getName();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getFullName() {
		return getCorrectCIdentifier(getName());
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getQualifiedName() {
		String qualifiedName = this.getUml2NamedElement().getName();

		Iterator it = this.getUml2NamedElement().allNamespaces().iterator();
		while (it.hasNext()) {
			Namespace namespace = (Namespace) it.next();
			qualifiedName = namespace.getName() + QUALIFIED_NAME_SEPARATOR + qualifiedName;
		}
		return qualifiedName;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2NamedElement.
	 */
	public org.eclipse.uml2.uml.NamedElement getUml2NamedElement() {
		return uml2NamedElement;
	}

	/**
	 * 
	 * 
	 * @param stereotypeName
	 *            select only stereotyped dependencies
	 * 
	 * @return named element link by dependency
	 */
	public Set<org.eclipse.uml2.uml.NamedElement> getUsedElements(String stereotypeName) {
		// Return every element link to current elelment with a dependency

		Set<org.eclipse.uml2.uml.NamedElement> usedElements = new HashSet<org.eclipse.uml2.uml.NamedElement>();

		Iterator dependenciesIt;
		Iterator cDependenciesIt;
		org.eclipse.uml2.uml.Dependency currentDependency;
		org.eclipse.papyrus.umlutils.Element currentDependencyElt;

		// Retrieve client dependency list (client / supplier relation)
		dependenciesIt = uml2NamedElement.getClientDependencies().iterator();

		while (dependenciesIt.hasNext()) {
			currentDependency = (org.eclipse.uml2.uml.Dependency) dependenciesIt.next();
			currentDependencyElt = new org.eclipse.papyrus.umlutils.Element(currentDependency);

			if (stereotypeName.equals("")) {
				// Retrieve the other side of the dependency
				cDependenciesIt = currentDependency.getTargets().iterator();
				while (cDependenciesIt.hasNext()) {
					usedElements.add((org.eclipse.uml2.uml.NamedElement) cDependenciesIt.next());
				}
			} else {
				// Retrieve the other side of the dependency
				if (currentDependencyElt.hasStereotype(stereotypeName)) {
					cDependenciesIt = currentDependency.getTargets().iterator();
					while (cDependenciesIt.hasNext()) {
						usedElements.add((org.eclipse.uml2.uml.NamedElement) cDependenciesIt.next());
					}
				}
			}

		}

		return usedElements;
	}

	/**
	 * Retrieve visibility value as string.
	 * 
	 * @return
	 * 
	 * @Return a String "", "Public", "Private", "Protected"
	 */
	public String getVisibilityAsString() {
		String vKindValue = "";

		if (uml2NamedElement.getVisibility().getValue() == org.eclipse.uml2.uml.VisibilityKind.PUBLIC) {
			vKindValue = "public";
		} else if (uml2NamedElement.getVisibility().getValue() == org.eclipse.uml2.uml.VisibilityKind.PROTECTED) {
			vKindValue = "protected";
		} else if (uml2NamedElement.getVisibility().getValue() == org.eclipse.uml2.uml.VisibilityKind.PRIVATE) {
			vKindValue = "private";
		} // else ""

		return vKindValue;
	}

	/**
	 * Give the visibility of the namedelement as a string, as defined in the UML2 standard.
	 * 
	 * @return A String representing the visibility of the namedelement. Possible values:
	 *         <ul>
	 *         <li>public: <code>"+"</code>
	 *         <li>private: <code>"-"</code>
	 *         <li>protected: <code>"#"</code>
	 *         <li>package: <code>"~"</code>
	 *         </ul>
	 */
	public String getVisibilityAsSign() {
		String vKindValue = "";

		switch (uml2NamedElement.getVisibility().getValue()) {
		case org.eclipse.uml2.uml.VisibilityKind.PUBLIC:
			vKindValue = "+";
			break;
		case org.eclipse.uml2.uml.VisibilityKind.PRIVATE:
			vKindValue = "-";
			break;
		case org.eclipse.uml2.uml.VisibilityKind.PACKAGE:
			vKindValue = "~";
			break;
		case org.eclipse.uml2.uml.VisibilityKind.PROTECTED:
			vKindValue = "#";
			break;
		}
		return vKindValue;
	}

	/**
	 * A helper method to calculate the max depth of an element
	 * 
	 * @param element
	 * @return
	 */
	public int getQualifiedNameMaxDepth() {
		int d = 0;
		String s = uml2NamedElement.getQualifiedName();
		int n = 0;
		while ((n = s.indexOf("::", n)) != -1) {
			n += 2;
			d++;
		}
		return d;
	}

}