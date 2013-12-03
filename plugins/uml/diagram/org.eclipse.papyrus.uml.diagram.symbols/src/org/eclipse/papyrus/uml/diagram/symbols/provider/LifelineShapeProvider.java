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
package org.eclipse.papyrus.uml.diagram.symbols.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Type;

/**
 * Shape Provider for lifeline. It is based on the Type of the TypedElement
 * represented by the lifeline (if any)
 * 
 * @author Camille Letavernier
 *
 */
public class LifelineShapeProvider extends TypedElementShapeProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * The "type" of a Lifeline is the type of the ConnectableElement represented by the Lifeline
	 */
	@Override
	protected Type getType(EObject view) {
		if (!(view instanceof View)) {
			return null;
		}

		Object element = ((View) view).getElement();
		if (element instanceof Lifeline) {
			Lifeline lifeline = (Lifeline)element;
			ConnectableElement typedElement = lifeline.getRepresents();
			if (typedElement != null) {
				return typedElement.getType();
			}
		}

		return null;
	}

}
