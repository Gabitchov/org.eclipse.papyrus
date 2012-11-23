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
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.uml2.uml.Element;

/**
 * The Modisco customizable label provider doesn't handle standard EObjects,
 * while standard EMF label providers don't handle MoDisco elements.
 * 
 * This label provider aggregates both a MoDisco label provider and an
 * EMF Label Provider.
 * 
 * @author Camille Letavernier
 */
public class UMLFilteredLabelProvider extends UMLLabelProvider implements IFilteredLabelProvider {

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

		//The element is a UML Element or can be adapted to an EObject
		EObject eObject = EMFHelper.getEObject(element);
		if(eObject == null) {
			return false;
		}
		if(eObject instanceof Element) {
			return true;
		}

		return false;
	}

}
