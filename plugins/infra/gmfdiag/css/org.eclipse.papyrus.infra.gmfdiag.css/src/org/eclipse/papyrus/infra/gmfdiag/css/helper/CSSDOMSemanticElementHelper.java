/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;


/**
 * A Helper for retrieving Views and Semantic elements from a
 * compatible object. It differs from {@link org.eclipse.papyrus.infra.gmfdiag.common.helper.SemanticElementHelper} as it is used
 * for building the CSS DOM Model, which is slightly different from the semantics
 * containment model (i.e. Compartments and Floating Labels appear in the DOM model,
 * although they are not semantics elements)
 *
 * Used for building the CSS DOM Model
 *
 * @author Camille Letavernier
 *
 */
public class CSSDOMSemanticElementHelper {

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

		//Add diagrams to the DOM model
		if(notationElement instanceof Diagram) {
			return notationElement;
		}

		//Add compartments to the DOM model
		if(notationElement instanceof BasicCompartment) {
			return notationElement;
		}

		//Add floating labels to the DOM model
		if(isFloatingLabel(notationElement)) {
			return notationElement;
		}

		//Copied from the generic Semantic Element Helper
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

		while(currentElement != null) {
			if(currentElement instanceof View) {
				return findSemanticElement(currentElement);
			}
			currentElement = currentElement.eContainer();
		}

		/*
		 * Remove the warning to avoid flooding the error log.
		 *
		 * This may happen in the following cases:
		 *
		 * - The element is at the root of the Notation model and is not a Diagram (Which may happen in corrupted models,
		 * or (maybe) non-Papyrus notation models, but shouldn't have a major impact)
		 * - The element is contained in an EMF ChangeDescription (e.g. Create + Undo creation)
		 *
		 * See Bug 430534
		 */
		//Activator.log.warn("Cannot find a valid source for " + notationElement);
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

	/**
	 * Tests whether the given View is a Floating label
	 *
	 * @param view
	 * @return
	 *         True if this is a Floating Label
	 */
	public static boolean isFloatingLabel(EObject notationElement) {
		if(!(notationElement instanceof DecorationNode)) {
			return false;
		}

		DecorationNode node = (DecorationNode)notationElement;

		if(node instanceof BasicCompartment) {
			return false;
		}

		if(node.eContainer() instanceof Connector) {
			return true;
		}

		if(node.eContainer() instanceof Shape) {
			if(node.getLayoutConstraint() != null) {
				return true;
			}
		}

		return false;
	}
}
