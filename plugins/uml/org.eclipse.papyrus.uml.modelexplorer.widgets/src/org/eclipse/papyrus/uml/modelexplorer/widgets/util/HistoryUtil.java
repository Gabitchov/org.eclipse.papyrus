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
package org.eclipse.papyrus.uml.modelexplorer.widgets.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


public class HistoryUtil {

	/**
	 * Returns a String identifying the History of selected values for the given object/feature
	 * 
	 * @param editedObject
	 * @param feature
	 * @param semanticRoot
	 * @return
	 */
	public static String getHistoryID(EObject editedObject, EStructuralFeature feature, EObject semanticRoot) {
		//		return String.format("history_%s:%s:%s", feature.getEType().getEPackage().getName(), feature.getEType().getName(), feature.getName()); //$NON-NLS-1$
		if(editedObject.eResource() == null) {
			return String.format("history_%s:%s:%s", feature.getEType().getEPackage().getName(), feature.getEType().getName(), feature.getName());
		}

		return String.format("history_%s:%s:%s:%s", editedObject.eResource().getURI(), feature.getEType().getEPackage().getName(), feature.getEType().getName(), feature.getName());
	}
}
