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
package org.eclipse.papyrus.infra.emf.providers;

import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.providers.IFilteredLabelProvider;

/**
 * A LabelProvider which only accepts EMF Objects (EObject, or objects which can be adapted to EObjects)
 * 
 * @author Camille Letavernier
 * 
 */
public class EMFFilteredLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	public boolean accept(IStructuredSelection selection) {
		if(selection.isEmpty()) {
			return false;
		}

		Iterator<?> iterator = selection.iterator();
		while(iterator.hasNext()) {
			Object element = iterator.next();
			if(!accept(element)) {
				return false;
			}
		}

		return true;
	}

	public boolean accept(Object element) {
		if(element instanceof IStructuredSelection) {
			return accept((IStructuredSelection)element);
		}

		//The element is an EObject or can be adapted to an EObject
		return EMFHelper.getEObject(element) != null;
	}

}
