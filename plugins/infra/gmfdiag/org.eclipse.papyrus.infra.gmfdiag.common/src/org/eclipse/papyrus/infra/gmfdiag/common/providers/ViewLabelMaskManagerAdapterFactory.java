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
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.style.ILabelMaskProvider;

/**
 * An AdapterFactory to retrieve a {@link ILabelMaskProvider} from a GMF {@link View}
 * 
 * It delegates the adapter resolution to the view's element (if not null)
 * 
 * @author Camille Letavernier
 * 
 */
public class ViewLabelMaskManagerAdapterFactory implements IAdapterFactory {

	/**
	 * {@inheritDoc}
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == ILabelMaskProvider.class && adaptableObject instanceof View) {
			//Forwards the resolution of the adapter to the view's semantic element
			View view = (View)adaptableObject;
			if(view.getElement() != null && view.getElement() != view) {
				return Platform.getAdapterManager().getAdapter(view.getElement(), adapterType);
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class[] getAdapterList() {
		return new Class[]{ ILabelMaskProvider.class };
	}

}