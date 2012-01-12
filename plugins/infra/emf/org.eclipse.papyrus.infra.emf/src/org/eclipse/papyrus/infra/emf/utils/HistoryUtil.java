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
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


public class HistoryUtil {

	/**
	 * Returns a String identifying the History of selected values for the given object/feature
	 * 
	 * @param editedObject
	 * @param feature
	 * @return
	 */
	public static String getHistoryID(EObject editedObject, EStructuralFeature feature) {
		return getHistoryID(editedObject, feature, "");
	}

	/**
	 * Returns a String identifying the History of selected values for the given object/feature,
	 * and prepends the given prefix
	 * 
	 * @param editedObject
	 * @param feature
	 * @return
	 */
	public static String getHistoryID(EObject editedObject, EStructuralFeature feature, String prefix) {
		//		return String.format("history_%s:%s:%s", feature.getEType().getEPackage().getName(), feature.getEType().getName(), feature.getName()); //$NON-NLS-1$
		if(editedObject.eResource() == null) {
			return String.format("history_%s_%s:%s", prefix, EMFHelper.getQualifiedName(feature.getEType(), ":"), feature.getName()); //$NON-NLS-1$ //$NON-NLS-2$
		}

		return String.format("history_%s_%s:%s:%s", prefix, editedObject.eResource().getURI(), EMFHelper.getQualifiedName(feature.getEType(), ":"), feature.getName()); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
