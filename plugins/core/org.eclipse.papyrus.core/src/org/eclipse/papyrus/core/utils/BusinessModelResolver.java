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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.core.utils;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;


/**
 * This class allows to retrieve the business object from an object representing a graphical artifact in a diagram. Each diagram can register its
 * resolver which will be added to the list of
 * resolvers. Some common resolvers are already registered : gef.EditPart TODO Use extensions to register additional resolvers.
 */
public class BusinessModelResolver {

	/**
	 * The unique instance
	 */
	public static BusinessModelResolver instance = new BusinessModelResolver();

	public BusinessModelResolver() {

	}

	/**
	 * Get the business object associated to this object, if any. This method navigate throw the object if the object is an graphical artefact or a
	 * diagram artifact.
	 * 
	 * @param object
	 * @return Object
	 */
	public Object getBusinessModel(Object object) {
		if(object instanceof EditPart) {
			// Check model. It can be a GraphNode.
			Object model = ((EditPart)object).getModel();
			if(model instanceof View) { // Notation / GMF
				return getBusinessElement((View)((EditPart)object).getModel());
			} else {
				return model;
			}

		} else if(object instanceof View) {
			return ((View)object).getElement();

		} else if(object instanceof IAdaptable) {
			// Among others this is useful to retrieve the selected object from 
			// an explorer item.
			return ((IAdaptable)object).getAdapter(EObject.class);

		} else {
			return object;
		}
	}


	/**
	 * Get the business object from a GraphElement.
	 * 
	 * @param object
	 * @return
	 */
	protected Object getBusinessElement(View object) {
		try {
			return object.getElement();
		} catch (NullPointerException e) {
			// no business element
			return null;
		}
	}

	/**
	 * Get the graphical object accessible from to this diagram object, if any.
	 * 
	 * @param object
	 * @return Object
	 */
	public Object getGraphicalModel(Object object) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	/**
	 * @return BusinessModelResolver
	 */
	public static BusinessModelResolver getInstance() {
		return instance;
	}
}
