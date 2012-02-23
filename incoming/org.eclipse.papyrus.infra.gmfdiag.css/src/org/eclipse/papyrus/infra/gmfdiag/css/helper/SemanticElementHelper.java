/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.Activator;

public class SemanticElementHelper {

	/**
	 * Returns the semantic element attached to the given notation element
	 * 
	 * The result element can also be a Diagram
	 */
	public static EObject findSemanticElement(EObject notationElement) {
		if(notationElement instanceof Diagram) {
			return notationElement;
		}

		EObject currentElement = notationElement;

		do {
			if(currentElement instanceof View) {
				View view = (View)currentElement;
				if(view.getElement() != null) {
					return view.getElement();
				}
				//The graphical element isn't related to a Semantic Element. The view becomes the semantic element.
				//e.g. : Links in UML
				return view;
			}
			currentElement = currentElement.eContainer();
		} while(currentElement != null);

		Activator.log.warn("Cannot find a valid source for " + notationElement);
		return notationElement;
	}

	/**
	 * Retrieves the primary view associated to the argument.
	 * 
	 * For example, for a compartment, this method will return the top-most
	 * view associated to the same semantic element.
	 * 
	 * @param notationElement
	 * @return
	 */
	public static View findPrimaryView(EObject notationElement) {
		return findTopView(notationElement);
	}

	/**
	 * Finds the top-most View associated to the same semantic
	 * element as the argument.
	 * 
	 * @param notationElement
	 * @return
	 */
	public static View findTopView(EObject notationElement) {
		EObject semanticElement = findSemanticElement(notationElement);

		if(semanticElement == notationElement) {
			return (View)notationElement;
		}

		EObject lastNotationElement = notationElement;
		while(notationElement != null) {
			notationElement = notationElement.eContainer();
			if(findSemanticElement(notationElement) != semanticElement) {
				return (View)lastNotationElement;
			}

			if(notationElement != null) {
				lastNotationElement = notationElement;
			}
		}

		return (View)lastNotationElement;
	}
}
