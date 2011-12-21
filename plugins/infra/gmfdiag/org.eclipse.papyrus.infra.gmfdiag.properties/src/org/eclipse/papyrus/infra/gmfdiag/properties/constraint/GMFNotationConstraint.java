/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.constraint;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.constraints.constraints.EMFInstanceOfConstraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A constraint for the GMF Notation metamodel
 * Retrieves the notation model from the selection,
 * then applies an EMFInstanceOfConstraint on the resulting
 * EObject
 * 
 * @author Camille Letavernier
 * 
 */
public class GMFNotationConstraint extends EMFInstanceOfConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean match(Object selection) {

		View view = null;

		if(selection instanceof EditPart) {
			EditPart part = (EditPart)selection;
			Object model = part.getModel();
			if(model instanceof View) {
				view = (View)model;
			}
		}

		EObject eObject = EMFHelper.getEObject(selection);
		if(eObject instanceof View) {
			view = (View)eObject;
		}

		return view == null ? false : super.match(view);
	}

}
