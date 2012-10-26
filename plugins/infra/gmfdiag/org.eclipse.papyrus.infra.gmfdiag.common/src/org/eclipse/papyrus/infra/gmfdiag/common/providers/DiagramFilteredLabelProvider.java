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

import java.util.Iterator;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.providers.IFilteredLabelProvider;

/**
 * A FilteredLabelProvider for GMF Diagrams
 * 
 * @author Camille Letavernier
 */
public class DiagramFilteredLabelProvider extends DiagramLabelProvider implements IFilteredLabelProvider {


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

		//The element is a Diagram or can be adapted to a Diagram
		return EMFHelper.getEObject(element) instanceof Diagram;
	}

}
