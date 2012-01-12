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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

public class ContainerContentProvider extends SemanticEMFContentProvider {

	protected EClass type;

	protected Object input;

	public ContainerContentProvider(EObject source, EReference reference) {
		super(source.eResource().getResourceSet());
		type = (EClass)reference.getEType();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		this.input = newInput;
		if(newInput instanceof EObject) {
			this.type = ((EObject)newInput).eClass();
		}
	}

	@Override
	public boolean isValidValue(Object value) {
		Object adaptedValue = getAdaptedValue(value);
		if(adaptedValue instanceof EObject) {
			//We cannot create objects in a read-only object
			if(EMFHelper.isReadOnly((EObject)adaptedValue)) {
				return false;
			}

			//We need at least one valid containment reference to store this
			//type of object
			for(EReference reference : ((EObject)adaptedValue).eClass().getEAllReferences()) {
				if(reference.isContainment() && EMFHelper.isSubclass(this.type, reference.getEReferenceType())) {
					return true;
				}
			}
		}
		return false;
	}
}
