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
package org.eclipse.papyrus.views.properties.providers;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;


public class EMFObjectFilteredLabelProvider extends EMFObjectLabelProvider implements IFilteredLabelProvider {

	public boolean accept(IStructuredSelection selection) {
		if(selection.size() == 1) {
			return accept(selection.getFirstElement());
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

	protected boolean accept(Object element) {
		if(element instanceof EObject) {
			return true;
		}

		if(element instanceof IAdaptable) {
			return ((IAdaptable)element).getAdapter(EObject.class) instanceof EObject;
		}

		return false;
	}

}
