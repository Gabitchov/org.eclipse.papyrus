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
			if(adapter != null) {
				return (View)adapter;
			}
			adapter =  EMFHelper.getEObject(adaptable);
			if(adapter instanceof View) {
				return (View)adapter;
			}
		}
		return null;
	}
}
