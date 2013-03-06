/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.adapters;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;

/**
 * This is the CDOAdapterFactory type. Enjoy.
 */
@SuppressWarnings("rawtypes")
public class CDOAdapterFactory
		implements IAdapterFactory {

	private final Class[] supported = {CDOObject.class};

	public CDOAdapterFactory() {
		super();
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		EObject eObject = null;
		if (adaptableObject instanceof EditPart) {
			// notation views are important as CDOObjects for locking and
			// conflict purposes, so do not defer to the semantic element
			eObject = (EObject) ((EditPart) adaptableObject).getModel();
		} else if (adaptableObject instanceof EObject) {
			eObject = (EObject) adaptableObject;
		} else {
			// try really hard to get an EObject
			if (adaptableObject instanceof IAdaptable) {
				eObject = (EObject) ((IAdaptable) adaptableObject)
					.getAdapter(EObject.class);
			}
			if (eObject == null) {
				eObject = (EObject) Platform.getAdapterManager()
					.getAdapter(adaptableObject, EObject.class);
			}
		}

		// get the CDOObject from the EObject (if possible)
		return CDOUtils.getCDOObject(eObject);
	}

	public Class[] getAdapterList() {
		return supported;
	}

}
