/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 386118
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A Helper class related to the GMF Notation metamodel.
 * 
 * @author Camille Letavernier
 */
public class NotationHelper {

	/**
	 * Retrieves the GMF View associated to the source object
	 * 
	 * @param source
	 *        the source
	 * @return the resolved view, or null if it cannot be found
	 */
	public static View findView(Object source) {
		if(source instanceof View) {
			return (View)source;
		}
		
		if(source instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)source;
			Object adapter = adaptable.getAdapter(View.class);
			if(adapter instanceof View) {
				return (View)adapter;
			}
		}
		
		EObject obj = EMFHelper.getEObject(source);
		return (obj instanceof View) ? (View) obj : null;
	}

	/**
	 * Tests whether the given View is a reference to an external element.
	 * A view is an external reference if its graphical container is different from its semantic
	 * container (i.e. self.element.eContainer() != self.primaryView.eContainer().element)
	 * 
	 * @param diagramElement
	 * @return
	 */
	public static boolean isExternalRef(View diagramElement) {
		if(diagramElement == null) {
			return false;
		}

		View primaryView = SemanticElementHelper.findTopView(diagramElement);
		if(primaryView == null) {
			return false;
		}

		EObject semanticElement = primaryView.getElement();

		if(semanticElement == null) {
			return false;
		}

		EObject parentView = primaryView.eContainer();
		if(!(parentView instanceof View)) {
			return false;
		}

		EObject parentSemanticElement = ((View)parentView).getElement();
		if(parentSemanticElement == null) {
			return false;
		}

		//Relax the constraints for elements displayed on themselves (e.g. Frame in Composite Structure Diagram)
		return parentSemanticElement != semanticElement.eContainer() && parentSemanticElement != semanticElement;
	}
}
