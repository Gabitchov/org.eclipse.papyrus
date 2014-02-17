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
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.Activator;

/**
 * A Helper for retrieving Views and Semantic elements from a
 * compatible object.
 * 
 * @author Camille Letavernier
 */
public class SemanticElementHelper {

	/**
	 * Returns the semantic element attached to the given notation element
	 * 
	 * The result element can also be a Diagram
	 * 
	 * @param notationElement
	 * @return
	 */
	public static EObject findSemanticElement(EObject notationElement) {
		if(notationElement == null) {
			return null;
		}

		if(notationElement instanceof Diagram) {
			return notationElement;
		}

		if(notationElement instanceof View) {
			View view = (View)notationElement;
			EObject semanticElement = view.getElement();
			if(semanticElement != null) {
				return semanticElement;
			}

			//The graphical element isn't related to a Semantic Element. The view becomes the semantic element.
			//e.g. : Links in UML
			return view;
		}

		EObject currentElement = notationElement.eContainer();

		do {
			if(currentElement instanceof View) {
				return findSemanticElement(currentElement);
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
	//@unused
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
	//@unused
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
