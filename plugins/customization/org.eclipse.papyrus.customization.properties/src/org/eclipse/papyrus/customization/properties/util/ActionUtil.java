/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * Utility class for Actions
 *
 * @author Camille Letavernier
 *
 */
public class ActionUtil {

	/**
	 * EMF can only handle collections of EObjects. However, as the
	 * customization plugin relies a lot on EMF Facet, we often have to handle
	 * objects that can be adapted to EObjects, but are not EObjects
	 * themselves. This method adapts a collections of such objects to their
	 * underlying EObjects, so that EMF can handle them.
	 * Objects that cannot be adapted remain as-is in the collection.
	 *
	 * @param selection
	 *        The collection to adapt
	 * @return
	 *         The adapted selection
	 */
	public static Collection<Object> getAdaptedSelection(Collection<? extends Object> selection) {
		Collection<Object> newSelection = new LinkedList<Object>();
		for(Object o : selection) {
			if(o instanceof IAdaptable) {
				EObject eObject = (EObject)((IAdaptable)o).getAdapter(EObject.class);
				newSelection.add(eObject);
			} else {
				newSelection.add(o);
			}
		}
		return newSelection;
	}

	/**
	 * EMF can only handle ISelection containing EObjects. However, as the
	 * customization plugin relies a lot on EMF Facet, we often have to handle
	 * objects that can be adapted to EObjects, but are not EObjects
	 * themselves. This method adapts a ISelection of such objects to their
	 * underlying EObjects, so that EMF can handle them.
	 * Objects that cannot be adapted remain as-is in the selection.
	 *
	 * @param sourceSelection
	 *        The selection to adapt
	 * @return
	 *         The adapted selection
	 */
	public static ISelection getAdaptedSelection(ISelection sourceSelection) {
		if(sourceSelection instanceof StructuredSelection) {
			StructuredSelection currentSelection = (StructuredSelection)sourceSelection;
			List<Object> newSelection = new LinkedList<Object>();

			Iterator<?> it = currentSelection.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				EObject eObject = EMFHelper.getEObject(object);
				if(eObject != null) {
					newSelection.add(eObject);
				} else {
					newSelection.add(object);
				}
			}

			StructuredSelection selection = new StructuredSelection(newSelection);
			return selection;
		} else {
			return sourceSelection;
		}
	}
}
