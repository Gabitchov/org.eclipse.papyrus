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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

public class FeatureContentProvider implements CreateInFeatureContentProvider {

	private EClass type;

	//	private Viewer viewer;

	private Object input;

	public FeatureContentProvider(EClass type) {
		this.type = type;
	}

	public void setType(EClass type) {
		this.type = type;
	}

	public void dispose() {
		// Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//		this.viewer = viewer;
		this.input = newInput;
	}

	public Object[] getElements() {
		return getElements(input);
	}

	public Object[] getElements(Object inputElement) {
		EObject inputEObject = EMFHelper.getEObject(input);
		if(inputEObject == null) {
			return new Object[0];
		}
		List<Object> elements = new LinkedList<Object>();
		for(EReference reference : inputEObject.eClass().getEAllReferences()) {
			if(reference.isContainment()) {
				if(EMFHelper.isSubclass(type, reference.getEReferenceType())) {
					elements.add(reference);
				}
			}
		}
		return elements.toArray();
	}
}